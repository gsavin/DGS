grammar DGS;

options {
  language = Java;
  memoize = false;
  backtrack = false;
}

@header {
package org.graphstream.stream.file;

import org.graphstream.stream.SourceBase;
import org.graphstream.stream.SourceBase.ElementType;
import org.graphstream.graph.implementations.AbstractElement.AttributeChangeEvent;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.LinkedList;
}

@lexer::header {
package org.graphstream.stream.file;
}

@members {
SourceBase source;
String sourceId;
LinkedList<String> attributeKeys = new LinkedList<String>();
LinkedList<Object> attributeValues = new LinkedList<Object>();
LinkedList<AttributeChangeEvent> attributeTypes = new LinkedList<AttributeChangeEvent>();

public void setSource(String id, SourceBase source) {
	this.sourceId = id;
	this.source = source;
}

private void addAttribute(String key, AttributeChangeEvent type, Object value) {
	attributeKeys.add(key);
	attributeTypes.add(type);
	attributeValues.add(value);
}

private void flushAttributes(ElementType elementType,
		String elementId) {
	String key;
	Object value;
	AttributeChangeEvent type;

	for (int i = 0; i < attributeKeys.size(); i++) {
		key = attributeKeys.get(i);
		value = attributeValues.get(i);
		type = attributeTypes.get(i);

		source.sendAttributeChangedEvent(sourceId, elementId, elementType, key,
				type, null, value);
	}

	attributeKeys.clear();
	attributeValues.clear();
	attributeTypes.clear();
}
}

unquoted_string returns [String str]
  : STRING { $str = $STRING.text.substring(1, $STRING.text.length()-1); }
  ;

header
  : DGS_MAGIC EOL id NUMBER NUMBER timestamp_format? EOL
  ;

id returns [String id]
  : IDENTIFIER { $id = $IDENTIFIER.getText(); }
  | us=unquoted_string { $id = us; }
  | NUMBER { $id = $NUMBER.getText(); }
  ;

key returns [String key]
  : k=id { $key = k; }
  ;

timestamp_format
  : STRING
  ;

timestamp
  : (DATE|HOUR)+
  | STRING
  ;

attributes
  : attribute*
  ;

attribute
  : MINUS k=key { addAttribute(k, AttributeChangeEvent.REMOVE, null); }
  | { AttributeChangeEvent t = AttributeChangeEvent.CHANGE; }
    (PLUS { t = AttributeChangeEvent.ADD; })? 
    k=key assign_to v=attribute_value { addAttribute(k, t, v); }
  ;

assign_to
  : COLON
  | EQUAL
  ;

attribute_value returns [Object value]
  : STRING                  { $value = $STRING.getText(); }
  | NUMBER                  { $value = new Integer($NUMBER.getText()); }
  | REAL                    { $value = new Double($REAL.getText()); }
  | v=attribute_array_value { $value = v; }
  | v=attribute_map_value   { $value = v; }
  ;

attribute_map_value returns [Object map]
  : LBRACKET { HashMap<String, Object> m = new HashMap<String, Object>(); }
  (
    e=mapping { m.entrySet().add(e); }
    (COMMA e=mapping { m.entrySet().add(e); })*
  )?
  RBRACKET { $map = m; }
  ;

mapping returns [SimpleEntry<String,Object> entry]
  : k=key assign_to v=attribute_value 
  { entry = new SimpleEntry<String, Object>(k, v); }
  ;

attribute_array_value returns [Object objects]
  :
  LBRACE { LinkedList<Object> list = new LinkedList<Object>(); }
  (
    o=attribute_value { list.add(o); }
    (COMMA o=attribute_value { list.add(o); })*
  )?
  RBRACE { $objects = list.toArray(); }
  ;

directive returns [boolean r]
  :
  (timestamp?
    (
      add_node
      | delete_node
      | change_node
      | add_edge
      | delete_edge
      | change_edge
      | change_graph
      | step
    )
    EOL { $r = true; }
  | EOF { $r = false; }
  )
  ;

add_node
  : ADD_NODE nodeId=id 
  { source.sendNodeAdded(sourceId, nodeId); } 
  attributes
  { flushAttributes(ElementType.NODE, nodeId); }
  ;

delete_node
  : DELETE_NODE nodeId=id
  { source.sendNodeRemoved(sourceId, nodeId); }
  ;

change_node
  : CHANGE_NODE nodeId=id attributes
  { flushAttributes(ElementType.NODE, nodeId); }
  ;

add_edge
  : { int directed = 0; }
  ADD_EDGE edgeId=id n0=id
  (
    LESS   { directed = -1; }
    | MORE { directed = 1; }
  )?
  n1=id
  { source.sendEdgeAdded(sourceId, edgeId, directed < 0 ? n1 : n0, directed < 0 ? n0 : n1, directed != 0); }
  attributes
  { flushAttributes(ElementType.EDGE, edgeId); }
  ;

delete_edge
  : DELETE_EDGE edgeId=id
  { source.sendEdgeRemoved(sourceId, edgeId); }
  ;

change_edge
  : CHANGE_EDGE edgeId=id attributes
  { flushAttributes(ElementType.EDGE, edgeId); }
  ;

change_graph
  : CHANGE_GRAPH attributes
  { flushAttributes(ElementType.GRAPH, null); }
  ;

step
  : STEP s=REAL
  { source.sendStepBegins(sourceId, Double.parseDouble(s.getText()));  }
  ;

fragment DIGIT  : '0'..'9' ;
fragment LETTER : 'a'..'z' | 'A'..'Z' ;

NUMBER : DIGIT+ ;
REAL   : (MINUS|PLUS)? DIGIT+ (DOT DIGIT+)? ;
STRING : '\"' .* '\"' ;

DGS_MAGIC : 'DGS003' | 'DGS004' ;

ADD_NODE     : 'an' ;
DELETE_NODE  : 'dn' ;
CHANGE_NODE  : 'cn' ;
ADD_EDGE     : 'ae' ;
DELETE_EDGE  : 'de' ;
CHANGE_EDGE  : 'ce' ;
CHANGE_GRAPH : 'cg' ;
STEP         : 'st' ;

LBRACKET   : '[' ;
RBRACKET   : ']' ;
LBRACE     : '{' ;
RBRACE     : '}' ;
COMMA      : ',' ;
DOT        : '.' ;
PLUS       : '+' ;
MINUS      : '-' ;
COLON      : ':' ;
EQUAL      : '=' ;
UNDERSCORE : '_' ;
SLASH      : '/' ;
LESS       : '<' ;
MORE       : '>' ;

DATE : DIGIT+ MINUS DIGIT+ MINUS DIGIT+ ;
HOUR : DIGIT+ COLON DIGIT+ ;

IDENTIFIER : LETTER (DOT? (LETTER|DIGIT|UNDERSCORE))* ;

WS : (' '|'\t')+ { $channel = HIDDEN; } ;
COMMENT : '/*' .* '*/' { $channel = HIDDEN; } ;

EOL : '\r'? '\n' ;
