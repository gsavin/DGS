// $ANTLR 3.2 debian-5 DGS.g 2011-04-28 13:46:26

package org.graphstream.stream.file;

import org.graphstream.stream.SourceBase;
import org.graphstream.stream.SourceBase.ElementType;
import org.graphstream.graph.implementations.AbstractElement.AttributeChangeEvent;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.LinkedList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DGSParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "DGS_MAGIC", "EOL", "NUMBER", "IDENTIFIER", "DATE", "HOUR", "MINUS", "PLUS", "COLON", "EQUAL", "REAL", "LBRACKET", "COMMA", "RBRACKET", "LBRACE", "RBRACE", "ADD_NODE", "DELETE_NODE", "CHANGE_NODE", "ADD_EDGE", "LESS", "MORE", "DELETE_EDGE", "CHANGE_EDGE", "CHANGE_GRAPH", "STEP", "DIGIT", "LETTER", "DOT", "UNDERSCORE", "SLASH", "WS", "COMMENT"
    };
    public static final int DELETE_EDGE=27;
    public static final int DGS_MAGIC=5;
    public static final int RBRACE=20;
    public static final int LETTER=32;
    public static final int ADD_NODE=21;
    public static final int LBRACE=19;
    public static final int NUMBER=7;
    public static final int STEP=30;
    public static final int UNDERSCORE=34;
    public static final int MINUS=11;
    public static final int HOUR=10;
    public static final int EOF=-1;
    public static final int DELETE_NODE=22;
    public static final int COLON=13;
    public static final int LBRACKET=16;
    public static final int REAL=15;
    public static final int WS=36;
    public static final int SLASH=35;
    public static final int EOL=6;
    public static final int MORE=26;
    public static final int COMMA=17;
    public static final int IDENTIFIER=8;
    public static final int CHANGE_GRAPH=29;
    public static final int EQUAL=14;
    public static final int LESS=25;
    public static final int CHANGE_NODE=23;
    public static final int PLUS=12;
    public static final int DIGIT=31;
    public static final int ADD_EDGE=24;
    public static final int RBRACKET=18;
    public static final int COMMENT=37;
    public static final int DOT=33;
    public static final int DATE=9;
    public static final int CHANGE_EDGE=28;
    public static final int STRING=4;

    // delegates
    // delegators


        public DGSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public DGSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return DGSParser.tokenNames; }
    public String getGrammarFileName() { return "DGS.g"; }


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



    // $ANTLR start "unquoted_string"
    // DGS.g:64:1: unquoted_string returns [String str] : STRING ;
    public final String unquoted_string() throws RecognitionException {
        String str = null;

        Token STRING1=null;

        try {
            // DGS.g:65:3: ( STRING )
            // DGS.g:65:5: STRING
            {
            STRING1=(Token)match(input,STRING,FOLLOW_STRING_in_unquoted_string69); 
             str = (STRING1!=null?STRING1.getText():null).substring(1, (STRING1!=null?STRING1.getText():null).length()-1); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "unquoted_string"


    // $ANTLR start "header"
    // DGS.g:68:1: header : DGS_MAGIC EOL id NUMBER NUMBER ( timestamp_format )? EOL ;
    public final void header() throws RecognitionException {
        try {
            // DGS.g:69:3: ( DGS_MAGIC EOL id NUMBER NUMBER ( timestamp_format )? EOL )
            // DGS.g:69:5: DGS_MAGIC EOL id NUMBER NUMBER ( timestamp_format )? EOL
            {
            match(input,DGS_MAGIC,FOLLOW_DGS_MAGIC_in_header84); 
            match(input,EOL,FOLLOW_EOL_in_header86); 
            pushFollow(FOLLOW_id_in_header88);
            id();

            state._fsp--;

            match(input,NUMBER,FOLLOW_NUMBER_in_header90); 
            match(input,NUMBER,FOLLOW_NUMBER_in_header92); 
            // DGS.g:69:36: ( timestamp_format )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==STRING) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // DGS.g:69:36: timestamp_format
                    {
                    pushFollow(FOLLOW_timestamp_format_in_header94);
                    timestamp_format();

                    state._fsp--;


                    }
                    break;

            }

            match(input,EOL,FOLLOW_EOL_in_header97); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "header"


    // $ANTLR start "id"
    // DGS.g:72:1: id returns [String id] : ( IDENTIFIER | us= unquoted_string | NUMBER );
    public final String id() throws RecognitionException {
        String id = null;

        Token IDENTIFIER2=null;
        Token NUMBER3=null;
        String us = null;


        try {
            // DGS.g:73:3: ( IDENTIFIER | us= unquoted_string | NUMBER )
            int alt2=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt2=1;
                }
                break;
            case STRING:
                {
                alt2=2;
                }
                break;
            case NUMBER:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // DGS.g:73:5: IDENTIFIER
                    {
                    IDENTIFIER2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_id114); 
                     id = IDENTIFIER2.getText(); 

                    }
                    break;
                case 2 :
                    // DGS.g:74:5: us= unquoted_string
                    {
                    pushFollow(FOLLOW_unquoted_string_in_id124);
                    us=unquoted_string();

                    state._fsp--;

                     id = us; 

                    }
                    break;
                case 3 :
                    // DGS.g:75:5: NUMBER
                    {
                    NUMBER3=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_id132); 
                     id = NUMBER3.getText(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "id"


    // $ANTLR start "key"
    // DGS.g:78:1: key returns [String key] : k= id ;
    public final String key() throws RecognitionException {
        String key = null;

        String k = null;


        try {
            // DGS.g:79:3: (k= id )
            // DGS.g:79:5: k= id
            {
            pushFollow(FOLLOW_id_in_key153);
            k=id();

            state._fsp--;

             key = k; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return key;
    }
    // $ANTLR end "key"


    // $ANTLR start "timestamp_format"
    // DGS.g:82:1: timestamp_format : STRING ;
    public final void timestamp_format() throws RecognitionException {
        try {
            // DGS.g:83:3: ( STRING )
            // DGS.g:83:5: STRING
            {
            match(input,STRING,FOLLOW_STRING_in_timestamp_format168); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "timestamp_format"


    // $ANTLR start "timestamp"
    // DGS.g:86:1: timestamp : ( ( DATE | HOUR )+ | STRING );
    public final void timestamp() throws RecognitionException {
        try {
            // DGS.g:87:3: ( ( DATE | HOUR )+ | STRING )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=DATE && LA4_0<=HOUR)) ) {
                alt4=1;
            }
            else if ( (LA4_0==STRING) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // DGS.g:87:5: ( DATE | HOUR )+
                    {
                    // DGS.g:87:5: ( DATE | HOUR )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=DATE && LA3_0<=HOUR)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // DGS.g:
                    	    {
                    	    if ( (input.LA(1)>=DATE && input.LA(1)<=HOUR) ) {
                    	        input.consume();
                    	        state.errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // DGS.g:88:5: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_timestamp192); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "timestamp"


    // $ANTLR start "attributes"
    // DGS.g:91:1: attributes : ( attribute )* ;
    public final void attributes() throws RecognitionException {
        try {
            // DGS.g:92:3: ( ( attribute )* )
            // DGS.g:92:5: ( attribute )*
            {
            // DGS.g:92:5: ( attribute )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==STRING||(LA5_0>=NUMBER && LA5_0<=IDENTIFIER)||(LA5_0>=MINUS && LA5_0<=PLUS)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // DGS.g:92:5: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attributes205);
            	    attribute();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "attributes"


    // $ANTLR start "attribute"
    // DGS.g:95:1: attribute : ( MINUS k= key | ( PLUS )? k= key assign_to v= attribute_value );
    public final void attribute() throws RecognitionException {
        String k = null;

        Object v = null;


        try {
            // DGS.g:96:3: ( MINUS k= key | ( PLUS )? k= key assign_to v= attribute_value )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==MINUS) ) {
                alt7=1;
            }
            else if ( (LA7_0==STRING||(LA7_0>=NUMBER && LA7_0<=IDENTIFIER)||LA7_0==PLUS) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // DGS.g:96:5: MINUS k= key
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_attribute219); 
                    pushFollow(FOLLOW_key_in_attribute223);
                    k=key();

                    state._fsp--;

                     addAttribute(k, AttributeChangeEvent.REMOVE, null); 

                    }
                    break;
                case 2 :
                    // DGS.g:97:5: ( PLUS )? k= key assign_to v= attribute_value
                    {
                     AttributeChangeEvent t = AttributeChangeEvent.CHANGE; 
                    // DGS.g:98:5: ( PLUS )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==PLUS) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // DGS.g:98:6: PLUS
                            {
                            match(input,PLUS,FOLLOW_PLUS_in_attribute238); 
                             t = AttributeChangeEvent.ADD; 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_key_in_attribute251);
                    k=key();

                    state._fsp--;

                    pushFollow(FOLLOW_assign_to_in_attribute253);
                    assign_to();

                    state._fsp--;

                    pushFollow(FOLLOW_attribute_value_in_attribute257);
                    v=attribute_value();

                    state._fsp--;

                     addAttribute(k, t, v); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "attribute"


    // $ANTLR start "assign_to"
    // DGS.g:102:1: assign_to : ( COLON | EQUAL );
    public final void assign_to() throws RecognitionException {
        try {
            // DGS.g:103:3: ( COLON | EQUAL )
            // DGS.g:
            {
            if ( (input.LA(1)>=COLON && input.LA(1)<=EQUAL) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "assign_to"


    // $ANTLR start "attribute_value"
    // DGS.g:107:1: attribute_value returns [Object value] : ( STRING | NUMBER | REAL | v= attribute_array_value | v= attribute_map_value );
    public final Object attribute_value() throws RecognitionException {
        Object value = null;

        Token STRING4=null;
        Token NUMBER5=null;
        Token REAL6=null;
        Object v = null;


        try {
            // DGS.g:108:3: ( STRING | NUMBER | REAL | v= attribute_array_value | v= attribute_map_value )
            int alt8=5;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt8=1;
                }
                break;
            case NUMBER:
                {
                alt8=2;
                }
                break;
            case REAL:
                {
                alt8=3;
                }
                break;
            case LBRACE:
                {
                alt8=4;
                }
                break;
            case LBRACKET:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // DGS.g:108:5: STRING
                    {
                    STRING4=(Token)match(input,STRING,FOLLOW_STRING_in_attribute_value295); 
                     value = STRING4.getText(); 

                    }
                    break;
                case 2 :
                    // DGS.g:109:5: NUMBER
                    {
                    NUMBER5=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_attribute_value320); 
                     value = new Integer(NUMBER5.getText()); 

                    }
                    break;
                case 3 :
                    // DGS.g:110:5: REAL
                    {
                    REAL6=(Token)match(input,REAL,FOLLOW_REAL_in_attribute_value345); 
                     value = new Double(REAL6.getText()); 

                    }
                    break;
                case 4 :
                    // DGS.g:111:5: v= attribute_array_value
                    {
                    pushFollow(FOLLOW_attribute_array_value_in_attribute_value374);
                    v=attribute_array_value();

                    state._fsp--;

                     value = v; 

                    }
                    break;
                case 5 :
                    // DGS.g:112:5: v= attribute_map_value
                    {
                    pushFollow(FOLLOW_attribute_map_value_in_attribute_value384);
                    v=attribute_map_value();

                    state._fsp--;

                     value = v; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "attribute_value"


    // $ANTLR start "attribute_map_value"
    // DGS.g:115:1: attribute_map_value returns [Object map] : LBRACKET (e= mapping ( COMMA e= mapping )* )? RBRACKET ;
    public final Object attribute_map_value() throws RecognitionException {
        Object map = null;

        SimpleEntry<String,Object> e = null;


        try {
            // DGS.g:116:3: ( LBRACKET (e= mapping ( COMMA e= mapping )* )? RBRACKET )
            // DGS.g:116:5: LBRACKET (e= mapping ( COMMA e= mapping )* )? RBRACKET
            {
            match(input,LBRACKET,FOLLOW_LBRACKET_in_attribute_map_value405); 
             HashMap<String, Object> m = new HashMap<String, Object>(); 
            // DGS.g:117:3: (e= mapping ( COMMA e= mapping )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==STRING||(LA10_0>=NUMBER && LA10_0<=IDENTIFIER)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // DGS.g:118:5: e= mapping ( COMMA e= mapping )*
                    {
                    pushFollow(FOLLOW_mapping_in_attribute_map_value419);
                    e=mapping();

                    state._fsp--;

                     m.entrySet().add(e); 
                    // DGS.g:119:5: ( COMMA e= mapping )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==COMMA) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // DGS.g:119:6: COMMA e= mapping
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_attribute_map_value428); 
                    	    pushFollow(FOLLOW_mapping_in_attribute_map_value432);
                    	    e=mapping();

                    	    state._fsp--;

                    	     m.entrySet().add(e); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RBRACKET,FOLLOW_RBRACKET_in_attribute_map_value445); 
             map = m; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return map;
    }
    // $ANTLR end "attribute_map_value"


    // $ANTLR start "mapping"
    // DGS.g:124:1: mapping returns [SimpleEntry<String,Object> entry] : k= key assign_to v= attribute_value ;
    public final SimpleEntry<String,Object> mapping() throws RecognitionException {
        SimpleEntry<String,Object> entry = null;

        String k = null;

        Object v = null;


        try {
            // DGS.g:125:3: (k= key assign_to v= attribute_value )
            // DGS.g:125:5: k= key assign_to v= attribute_value
            {
            pushFollow(FOLLOW_key_in_mapping466);
            k=key();

            state._fsp--;

            pushFollow(FOLLOW_assign_to_in_mapping468);
            assign_to();

            state._fsp--;

            pushFollow(FOLLOW_attribute_value_in_mapping472);
            v=attribute_value();

            state._fsp--;

             entry = new SimpleEntry<String, Object>(k, v); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return entry;
    }
    // $ANTLR end "mapping"


    // $ANTLR start "attribute_array_value"
    // DGS.g:129:1: attribute_array_value returns [Object objects] : LBRACE (o= attribute_value ( COMMA o= attribute_value )* )? RBRACE ;
    public final Object attribute_array_value() throws RecognitionException {
        Object objects = null;

        Object o = null;


        try {
            // DGS.g:130:3: ( LBRACE (o= attribute_value ( COMMA o= attribute_value )* )? RBRACE )
            // DGS.g:131:3: LBRACE (o= attribute_value ( COMMA o= attribute_value )* )? RBRACE
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_attribute_array_value496); 
             LinkedList<Object> list = new LinkedList<Object>(); 
            // DGS.g:132:3: (o= attribute_value ( COMMA o= attribute_value )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==STRING||LA12_0==NUMBER||(LA12_0>=REAL && LA12_0<=LBRACKET)||LA12_0==LBRACE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // DGS.g:133:5: o= attribute_value ( COMMA o= attribute_value )*
                    {
                    pushFollow(FOLLOW_attribute_value_in_attribute_array_value510);
                    o=attribute_value();

                    state._fsp--;

                     list.add(o); 
                    // DGS.g:134:5: ( COMMA o= attribute_value )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==COMMA) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // DGS.g:134:6: COMMA o= attribute_value
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_attribute_array_value519); 
                    	    pushFollow(FOLLOW_attribute_value_in_attribute_array_value523);
                    	    o=attribute_value();

                    	    state._fsp--;

                    	     list.add(o); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RBRACE,FOLLOW_RBRACE_in_attribute_array_value536); 
             objects = list.toArray(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return objects;
    }
    // $ANTLR end "attribute_array_value"


    // $ANTLR start "directive"
    // DGS.g:139:1: directive returns [boolean r] : ( ( timestamp )? ( add_node | delete_node | change_node | add_edge | delete_edge | change_edge | change_graph | step ) EOL | EOF ) ;
    public final boolean directive() throws RecognitionException {
        boolean r = false;

        try {
            // DGS.g:140:3: ( ( ( timestamp )? ( add_node | delete_node | change_node | add_edge | delete_edge | change_edge | change_graph | step ) EOL | EOF ) )
            // DGS.g:141:3: ( ( timestamp )? ( add_node | delete_node | change_node | add_edge | delete_edge | change_edge | change_graph | step ) EOL | EOF )
            {
            // DGS.g:141:3: ( ( timestamp )? ( add_node | delete_node | change_node | add_edge | delete_edge | change_edge | change_graph | step ) EOL | EOF )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==STRING||(LA15_0>=DATE && LA15_0<=HOUR)||(LA15_0>=ADD_NODE && LA15_0<=ADD_EDGE)||(LA15_0>=DELETE_EDGE && LA15_0<=STEP)) ) {
                alt15=1;
            }
            else if ( (LA15_0==EOF) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // DGS.g:141:4: ( timestamp )? ( add_node | delete_node | change_node | add_edge | delete_edge | change_edge | change_graph | step ) EOL
                    {
                    // DGS.g:141:4: ( timestamp )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==STRING||(LA13_0>=DATE && LA13_0<=HOUR)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // DGS.g:141:4: timestamp
                            {
                            pushFollow(FOLLOW_timestamp_in_directive558);
                            timestamp();

                            state._fsp--;


                            }
                            break;

                    }

                    // DGS.g:142:5: ( add_node | delete_node | change_node | add_edge | delete_edge | change_edge | change_graph | step )
                    int alt14=8;
                    switch ( input.LA(1) ) {
                    case ADD_NODE:
                        {
                        alt14=1;
                        }
                        break;
                    case DELETE_NODE:
                        {
                        alt14=2;
                        }
                        break;
                    case CHANGE_NODE:
                        {
                        alt14=3;
                        }
                        break;
                    case ADD_EDGE:
                        {
                        alt14=4;
                        }
                        break;
                    case DELETE_EDGE:
                        {
                        alt14=5;
                        }
                        break;
                    case CHANGE_EDGE:
                        {
                        alt14=6;
                        }
                        break;
                    case CHANGE_GRAPH:
                        {
                        alt14=7;
                        }
                        break;
                    case STEP:
                        {
                        alt14=8;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }

                    switch (alt14) {
                        case 1 :
                            // DGS.g:143:7: add_node
                            {
                            pushFollow(FOLLOW_add_node_in_directive573);
                            add_node();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // DGS.g:144:9: delete_node
                            {
                            pushFollow(FOLLOW_delete_node_in_directive583);
                            delete_node();

                            state._fsp--;


                            }
                            break;
                        case 3 :
                            // DGS.g:145:9: change_node
                            {
                            pushFollow(FOLLOW_change_node_in_directive593);
                            change_node();

                            state._fsp--;


                            }
                            break;
                        case 4 :
                            // DGS.g:146:9: add_edge
                            {
                            pushFollow(FOLLOW_add_edge_in_directive603);
                            add_edge();

                            state._fsp--;


                            }
                            break;
                        case 5 :
                            // DGS.g:147:9: delete_edge
                            {
                            pushFollow(FOLLOW_delete_edge_in_directive613);
                            delete_edge();

                            state._fsp--;


                            }
                            break;
                        case 6 :
                            // DGS.g:148:9: change_edge
                            {
                            pushFollow(FOLLOW_change_edge_in_directive623);
                            change_edge();

                            state._fsp--;


                            }
                            break;
                        case 7 :
                            // DGS.g:149:9: change_graph
                            {
                            pushFollow(FOLLOW_change_graph_in_directive633);
                            change_graph();

                            state._fsp--;


                            }
                            break;
                        case 8 :
                            // DGS.g:150:9: step
                            {
                            pushFollow(FOLLOW_step_in_directive643);
                            step();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,EOL,FOLLOW_EOL_in_directive655); 
                     r = true; 

                    }
                    break;
                case 2 :
                    // DGS.g:153:5: EOF
                    {
                    match(input,EOF,FOLLOW_EOF_in_directive663); 
                     r = false; 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return r;
    }
    // $ANTLR end "directive"


    // $ANTLR start "add_node"
    // DGS.g:157:1: add_node : ADD_NODE nodeId= id attributes ;
    public final void add_node() throws RecognitionException {
        String nodeId = null;


        try {
            // DGS.g:158:3: ( ADD_NODE nodeId= id attributes )
            // DGS.g:158:5: ADD_NODE nodeId= id attributes
            {
            match(input,ADD_NODE,FOLLOW_ADD_NODE_in_add_node682); 
            pushFollow(FOLLOW_id_in_add_node686);
            nodeId=id();

            state._fsp--;

             source.sendNodeAdded(sourceId, nodeId); 
            pushFollow(FOLLOW_attributes_in_add_node696);
            attributes();

            state._fsp--;

             flushAttributes(ElementType.NODE, nodeId); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "add_node"


    // $ANTLR start "delete_node"
    // DGS.g:164:1: delete_node : DELETE_NODE nodeId= id ;
    public final void delete_node() throws RecognitionException {
        String nodeId = null;


        try {
            // DGS.g:165:3: ( DELETE_NODE nodeId= id )
            // DGS.g:165:5: DELETE_NODE nodeId= id
            {
            match(input,DELETE_NODE,FOLLOW_DELETE_NODE_in_delete_node713); 
            pushFollow(FOLLOW_id_in_delete_node717);
            nodeId=id();

            state._fsp--;

             source.sendNodeRemoved(sourceId, nodeId); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delete_node"


    // $ANTLR start "change_node"
    // DGS.g:169:1: change_node : CHANGE_NODE nodeId= id attributes ;
    public final void change_node() throws RecognitionException {
        String nodeId = null;


        try {
            // DGS.g:170:3: ( CHANGE_NODE nodeId= id attributes )
            // DGS.g:170:5: CHANGE_NODE nodeId= id attributes
            {
            match(input,CHANGE_NODE,FOLLOW_CHANGE_NODE_in_change_node734); 
            pushFollow(FOLLOW_id_in_change_node738);
            nodeId=id();

            state._fsp--;

            pushFollow(FOLLOW_attributes_in_change_node740);
            attributes();

            state._fsp--;

             flushAttributes(ElementType.NODE, nodeId); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "change_node"


    // $ANTLR start "add_edge"
    // DGS.g:174:1: add_edge : ADD_EDGE edgeId= id n0= id ( LESS | MORE )? n1= id attributes ;
    public final void add_edge() throws RecognitionException {
        String edgeId = null;

        String n0 = null;

        String n1 = null;


        try {
            // DGS.g:175:3: ( ADD_EDGE edgeId= id n0= id ( LESS | MORE )? n1= id attributes )
            // DGS.g:175:5: ADD_EDGE edgeId= id n0= id ( LESS | MORE )? n1= id attributes
            {
             int directed = 0; 
            match(input,ADD_EDGE,FOLLOW_ADD_EDGE_in_add_edge761); 
            pushFollow(FOLLOW_id_in_add_edge765);
            edgeId=id();

            state._fsp--;

            pushFollow(FOLLOW_id_in_add_edge769);
            n0=id();

            state._fsp--;

            // DGS.g:177:3: ( LESS | MORE )?
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LESS) ) {
                alt16=1;
            }
            else if ( (LA16_0==MORE) ) {
                alt16=2;
            }
            switch (alt16) {
                case 1 :
                    // DGS.g:178:5: LESS
                    {
                    match(input,LESS,FOLLOW_LESS_in_add_edge779); 
                     directed = -1; 

                    }
                    break;
                case 2 :
                    // DGS.g:179:7: MORE
                    {
                    match(input,MORE,FOLLOW_MORE_in_add_edge791); 
                     directed = 1; 

                    }
                    break;

            }

            pushFollow(FOLLOW_id_in_add_edge804);
            n1=id();

            state._fsp--;

             source.sendEdgeAdded(sourceId, edgeId, directed < 0 ? n1 : n0, directed < 0 ? n0 : n1, directed != 0); 
            pushFollow(FOLLOW_attributes_in_add_edge812);
            attributes();

            state._fsp--;

             flushAttributes(ElementType.EDGE, edgeId); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "add_edge"


    // $ANTLR start "delete_edge"
    // DGS.g:187:1: delete_edge : DELETE_EDGE edgeId= id ;
    public final void delete_edge() throws RecognitionException {
        String edgeId = null;


        try {
            // DGS.g:188:3: ( DELETE_EDGE edgeId= id )
            // DGS.g:188:5: DELETE_EDGE edgeId= id
            {
            match(input,DELETE_EDGE,FOLLOW_DELETE_EDGE_in_delete_edge829); 
            pushFollow(FOLLOW_id_in_delete_edge833);
            edgeId=id();

            state._fsp--;

             source.sendEdgeRemoved(sourceId, edgeId); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delete_edge"


    // $ANTLR start "change_edge"
    // DGS.g:192:1: change_edge : CHANGE_EDGE edgeId= id attributes ;
    public final void change_edge() throws RecognitionException {
        String edgeId = null;


        try {
            // DGS.g:193:3: ( CHANGE_EDGE edgeId= id attributes )
            // DGS.g:193:5: CHANGE_EDGE edgeId= id attributes
            {
            match(input,CHANGE_EDGE,FOLLOW_CHANGE_EDGE_in_change_edge850); 
            pushFollow(FOLLOW_id_in_change_edge854);
            edgeId=id();

            state._fsp--;

            pushFollow(FOLLOW_attributes_in_change_edge856);
            attributes();

            state._fsp--;

             flushAttributes(ElementType.EDGE, edgeId); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "change_edge"


    // $ANTLR start "change_graph"
    // DGS.g:197:1: change_graph : CHANGE_GRAPH attributes ;
    public final void change_graph() throws RecognitionException {
        try {
            // DGS.g:198:3: ( CHANGE_GRAPH attributes )
            // DGS.g:198:5: CHANGE_GRAPH attributes
            {
            match(input,CHANGE_GRAPH,FOLLOW_CHANGE_GRAPH_in_change_graph873); 
            pushFollow(FOLLOW_attributes_in_change_graph875);
            attributes();

            state._fsp--;

             flushAttributes(ElementType.GRAPH, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "change_graph"


    // $ANTLR start "step"
    // DGS.g:202:1: step : STEP s= REAL ;
    public final void step() throws RecognitionException {
        Token s=null;

        try {
            // DGS.g:203:3: ( STEP s= REAL )
            // DGS.g:203:5: STEP s= REAL
            {
            match(input,STEP,FOLLOW_STEP_in_step892); 
            s=(Token)match(input,REAL,FOLLOW_REAL_in_step896); 
             source.sendStepBegins(sourceId, Double.parseDouble(s.getText()));  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "step"

    // Delegated rules


 

    public static final BitSet FOLLOW_STRING_in_unquoted_string69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DGS_MAGIC_in_header84 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EOL_in_header86 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_header88 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NUMBER_in_header90 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NUMBER_in_header92 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_timestamp_format_in_header94 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EOL_in_header97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_id114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unquoted_string_in_id124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_id132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_key153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_timestamp_format168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_timestamp181 = new BitSet(new long[]{0x0000000000000602L});
    public static final BitSet FOLLOW_STRING_in_timestamp192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attributes205 = new BitSet(new long[]{0x0000000000001992L});
    public static final BitSet FOLLOW_MINUS_in_attribute219 = new BitSet(new long[]{0x0000000000001990L});
    public static final BitSet FOLLOW_key_in_attribute223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_attribute238 = new BitSet(new long[]{0x0000000000007990L});
    public static final BitSet FOLLOW_key_in_attribute251 = new BitSet(new long[]{0x0000000000007990L});
    public static final BitSet FOLLOW_assign_to_in_attribute253 = new BitSet(new long[]{0x0000000000098090L});
    public static final BitSet FOLLOW_attribute_value_in_attribute257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assign_to0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_attribute_value295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_attribute_value320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_attribute_value345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_array_value_in_attribute_value374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_map_value_in_attribute_value384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_attribute_map_value405 = new BitSet(new long[]{0x0000000000047990L});
    public static final BitSet FOLLOW_mapping_in_attribute_map_value419 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_COMMA_in_attribute_map_value428 = new BitSet(new long[]{0x0000000000007990L});
    public static final BitSet FOLLOW_mapping_in_attribute_map_value432 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RBRACKET_in_attribute_map_value445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_key_in_mapping466 = new BitSet(new long[]{0x0000000000007990L});
    public static final BitSet FOLLOW_assign_to_in_mapping468 = new BitSet(new long[]{0x0000000000098090L});
    public static final BitSet FOLLOW_attribute_value_in_mapping472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_attribute_array_value496 = new BitSet(new long[]{0x0000000000198090L});
    public static final BitSet FOLLOW_attribute_value_in_attribute_array_value510 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_COMMA_in_attribute_array_value519 = new BitSet(new long[]{0x0000000000098090L});
    public static final BitSet FOLLOW_attribute_value_in_attribute_array_value523 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_RBRACE_in_attribute_array_value536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timestamp_in_directive558 = new BitSet(new long[]{0x0000000079E00000L});
    public static final BitSet FOLLOW_add_node_in_directive573 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_delete_node_in_directive583 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_change_node_in_directive593 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_add_edge_in_directive603 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_delete_edge_in_directive613 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_change_edge_in_directive623 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_change_graph_in_directive633 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_step_in_directive643 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EOL_in_directive655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_directive663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_NODE_in_add_node682 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_add_node686 = new BitSet(new long[]{0x0000000000001990L});
    public static final BitSet FOLLOW_attributes_in_add_node696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_NODE_in_delete_node713 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_delete_node717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHANGE_NODE_in_change_node734 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_change_node738 = new BitSet(new long[]{0x0000000000001990L});
    public static final BitSet FOLLOW_attributes_in_change_node740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_EDGE_in_add_edge761 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_add_edge765 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_add_edge769 = new BitSet(new long[]{0x0000000006000190L});
    public static final BitSet FOLLOW_LESS_in_add_edge779 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_MORE_in_add_edge791 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_add_edge804 = new BitSet(new long[]{0x0000000000001990L});
    public static final BitSet FOLLOW_attributes_in_add_edge812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_EDGE_in_delete_edge829 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_delete_edge833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHANGE_EDGE_in_change_edge850 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_id_in_change_edge854 = new BitSet(new long[]{0x0000000000001990L});
    public static final BitSet FOLLOW_attributes_in_change_edge856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHANGE_GRAPH_in_change_graph873 = new BitSet(new long[]{0x0000000000001990L});
    public static final BitSet FOLLOW_attributes_in_change_graph875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STEP_in_step892 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_REAL_in_step896 = new BitSet(new long[]{0x0000000000000002L});

}