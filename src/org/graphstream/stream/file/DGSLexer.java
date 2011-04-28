// $ANTLR 3.2 debian-5 DGS.g 2011-04-28 13:46:27

package org.graphstream.stream.file;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DGSLexer extends Lexer {
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
    public static final int EOL=6;
    public static final int SLASH=35;
    public static final int WS=36;
    public static final int MORE=26;
    public static final int COMMA=17;
    public static final int IDENTIFIER=8;
    public static final int CHANGE_GRAPH=29;
    public static final int EQUAL=14;
    public static final int LESS=25;
    public static final int CHANGE_NODE=23;
    public static final int PLUS=12;
    public static final int DIGIT=31;
    public static final int RBRACKET=18;
    public static final int ADD_EDGE=24;
    public static final int DATE=9;
    public static final int DOT=33;
    public static final int COMMENT=37;
    public static final int CHANGE_EDGE=28;
    public static final int STRING=4;

    // delegates
    // delegators

    public DGSLexer() {;} 
    public DGSLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DGSLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "DGS.g"; }

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // DGS.g:207:17: ( '0' .. '9' )
            // DGS.g:207:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // DGS.g:208:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            // DGS.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:210:8: ( ( DIGIT )+ )
            // DGS.g:210:10: ( DIGIT )+
            {
            // DGS.g:210:10: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // DGS.g:210:10: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:211:8: ( ( MINUS | PLUS )? ( DIGIT )+ ( DOT ( DIGIT )+ )? )
            // DGS.g:211:10: ( MINUS | PLUS )? ( DIGIT )+ ( DOT ( DIGIT )+ )?
            {
            // DGS.g:211:10: ( MINUS | PLUS )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // DGS.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // DGS.g:211:24: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // DGS.g:211:24: DIGIT
            	    {
            	    mDIGIT(); 

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

            // DGS.g:211:31: ( DOT ( DIGIT )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='.') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // DGS.g:211:32: DOT ( DIGIT )+
                    {
                    mDOT(); 
                    // DGS.g:211:36: ( DIGIT )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // DGS.g:211:36: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:212:8: ( '\\\"' ( . )* '\\\"' )
            // DGS.g:212:10: '\\\"' ( . )* '\\\"'
            {
            match('\"'); 
            // DGS.g:212:15: ( . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\"') ) {
                    alt6=2;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // DGS.g:212:15: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "DGS_MAGIC"
    public final void mDGS_MAGIC() throws RecognitionException {
        try {
            int _type = DGS_MAGIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:214:11: ( 'DGS003' | 'DGS004' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='D') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='G') ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2=='S') ) {
                        int LA7_3 = input.LA(4);

                        if ( (LA7_3=='0') ) {
                            int LA7_4 = input.LA(5);

                            if ( (LA7_4=='0') ) {
                                int LA7_5 = input.LA(6);

                                if ( (LA7_5=='3') ) {
                                    alt7=1;
                                }
                                else if ( (LA7_5=='4') ) {
                                    alt7=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 7, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 7, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // DGS.g:214:13: 'DGS003'
                    {
                    match("DGS003"); 


                    }
                    break;
                case 2 :
                    // DGS.g:214:24: 'DGS004'
                    {
                    match("DGS004"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DGS_MAGIC"

    // $ANTLR start "ADD_NODE"
    public final void mADD_NODE() throws RecognitionException {
        try {
            int _type = ADD_NODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:216:14: ( 'an' )
            // DGS.g:216:16: 'an'
            {
            match("an"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ADD_NODE"

    // $ANTLR start "DELETE_NODE"
    public final void mDELETE_NODE() throws RecognitionException {
        try {
            int _type = DELETE_NODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:217:14: ( 'dn' )
            // DGS.g:217:16: 'dn'
            {
            match("dn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELETE_NODE"

    // $ANTLR start "CHANGE_NODE"
    public final void mCHANGE_NODE() throws RecognitionException {
        try {
            int _type = CHANGE_NODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:218:14: ( 'cn' )
            // DGS.g:218:16: 'cn'
            {
            match("cn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHANGE_NODE"

    // $ANTLR start "ADD_EDGE"
    public final void mADD_EDGE() throws RecognitionException {
        try {
            int _type = ADD_EDGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:219:14: ( 'ae' )
            // DGS.g:219:16: 'ae'
            {
            match("ae"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ADD_EDGE"

    // $ANTLR start "DELETE_EDGE"
    public final void mDELETE_EDGE() throws RecognitionException {
        try {
            int _type = DELETE_EDGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:220:14: ( 'de' )
            // DGS.g:220:16: 'de'
            {
            match("de"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELETE_EDGE"

    // $ANTLR start "CHANGE_EDGE"
    public final void mCHANGE_EDGE() throws RecognitionException {
        try {
            int _type = CHANGE_EDGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:221:14: ( 'ce' )
            // DGS.g:221:16: 'ce'
            {
            match("ce"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHANGE_EDGE"

    // $ANTLR start "CHANGE_GRAPH"
    public final void mCHANGE_GRAPH() throws RecognitionException {
        try {
            int _type = CHANGE_GRAPH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:222:14: ( 'cg' )
            // DGS.g:222:16: 'cg'
            {
            match("cg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHANGE_GRAPH"

    // $ANTLR start "STEP"
    public final void mSTEP() throws RecognitionException {
        try {
            int _type = STEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:223:14: ( 'st' )
            // DGS.g:223:16: 'st'
            {
            match("st"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STEP"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:225:12: ( '[' )
            // DGS.g:225:14: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:226:12: ( ']' )
            // DGS.g:226:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:227:12: ( '{' )
            // DGS.g:227:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:228:12: ( '}' )
            // DGS.g:228:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:229:12: ( ',' )
            // DGS.g:229:14: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:230:12: ( '.' )
            // DGS.g:230:14: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:231:12: ( '+' )
            // DGS.g:231:14: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:232:12: ( '-' )
            // DGS.g:232:14: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:233:12: ( ':' )
            // DGS.g:233:14: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:234:12: ( '=' )
            // DGS.g:234:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "UNDERSCORE"
    public final void mUNDERSCORE() throws RecognitionException {
        try {
            int _type = UNDERSCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:235:12: ( '_' )
            // DGS.g:235:14: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDERSCORE"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:236:12: ( '/' )
            // DGS.g:236:14: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:237:12: ( '<' )
            // DGS.g:237:14: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "MORE"
    public final void mMORE() throws RecognitionException {
        try {
            int _type = MORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:238:12: ( '>' )
            // DGS.g:238:14: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MORE"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:240:6: ( ( DIGIT )+ MINUS ( DIGIT )+ MINUS ( DIGIT )+ )
            // DGS.g:240:8: ( DIGIT )+ MINUS ( DIGIT )+ MINUS ( DIGIT )+
            {
            // DGS.g:240:8: ( DIGIT )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // DGS.g:240:8: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            mMINUS(); 
            // DGS.g:240:21: ( DIGIT )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // DGS.g:240:21: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            mMINUS(); 
            // DGS.g:240:34: ( DIGIT )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // DGS.g:240:34: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATE"

    // $ANTLR start "HOUR"
    public final void mHOUR() throws RecognitionException {
        try {
            int _type = HOUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:241:6: ( ( DIGIT )+ COLON ( DIGIT )+ )
            // DGS.g:241:8: ( DIGIT )+ COLON ( DIGIT )+
            {
            // DGS.g:241:8: ( DIGIT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // DGS.g:241:8: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            mCOLON(); 
            // DGS.g:241:21: ( DIGIT )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // DGS.g:241:21: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HOUR"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:243:12: ( LETTER ( ( DOT )? ( LETTER | DIGIT | UNDERSCORE ) )* )
            // DGS.g:243:14: LETTER ( ( DOT )? ( LETTER | DIGIT | UNDERSCORE ) )*
            {
            mLETTER(); 
            // DGS.g:243:21: ( ( DOT )? ( LETTER | DIGIT | UNDERSCORE ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='.'||(LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // DGS.g:243:22: ( DOT )? ( LETTER | DIGIT | UNDERSCORE )
            	    {
            	    // DGS.g:243:22: ( DOT )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0=='.') ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // DGS.g:243:22: DOT
            	            {
            	            mDOT(); 

            	            }
            	            break;

            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:245:4: ( ( ' ' | '\\t' )+ )
            // DGS.g:245:6: ( ' ' | '\\t' )+
            {
            // DGS.g:245:6: ( ' ' | '\\t' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='\t'||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // DGS.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:246:9: ( '/*' ( . )* '*/' )
            // DGS.g:246:11: '/*' ( . )* '*/'
            {
            match("/*"); 

            // DGS.g:246:16: ( . )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='*') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='/') ) {
                        alt16=2;
                    }
                    else if ( ((LA16_1>='\u0000' && LA16_1<='.')||(LA16_1>='0' && LA16_1<='\uFFFF')) ) {
                        alt16=1;
                    }


                }
                else if ( ((LA16_0>='\u0000' && LA16_0<=')')||(LA16_0>='+' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // DGS.g:246:16: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match("*/"); 

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "EOL"
    public final void mEOL() throws RecognitionException {
        try {
            int _type = EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // DGS.g:248:5: ( ( '\\r' )? '\\n' )
            // DGS.g:248:7: ( '\\r' )? '\\n'
            {
            // DGS.g:248:7: ( '\\r' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\r') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // DGS.g:248:7: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EOL"

    public void mTokens() throws RecognitionException {
        // DGS.g:1:8: ( NUMBER | REAL | STRING | DGS_MAGIC | ADD_NODE | DELETE_NODE | CHANGE_NODE | ADD_EDGE | DELETE_EDGE | CHANGE_EDGE | CHANGE_GRAPH | STEP | LBRACKET | RBRACKET | LBRACE | RBRACE | COMMA | DOT | PLUS | MINUS | COLON | EQUAL | UNDERSCORE | SLASH | LESS | MORE | DATE | HOUR | IDENTIFIER | WS | COMMENT | EOL )
        int alt18=32;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // DGS.g:1:10: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 2 :
                // DGS.g:1:17: REAL
                {
                mREAL(); 

                }
                break;
            case 3 :
                // DGS.g:1:22: STRING
                {
                mSTRING(); 

                }
                break;
            case 4 :
                // DGS.g:1:29: DGS_MAGIC
                {
                mDGS_MAGIC(); 

                }
                break;
            case 5 :
                // DGS.g:1:39: ADD_NODE
                {
                mADD_NODE(); 

                }
                break;
            case 6 :
                // DGS.g:1:48: DELETE_NODE
                {
                mDELETE_NODE(); 

                }
                break;
            case 7 :
                // DGS.g:1:60: CHANGE_NODE
                {
                mCHANGE_NODE(); 

                }
                break;
            case 8 :
                // DGS.g:1:72: ADD_EDGE
                {
                mADD_EDGE(); 

                }
                break;
            case 9 :
                // DGS.g:1:81: DELETE_EDGE
                {
                mDELETE_EDGE(); 

                }
                break;
            case 10 :
                // DGS.g:1:93: CHANGE_EDGE
                {
                mCHANGE_EDGE(); 

                }
                break;
            case 11 :
                // DGS.g:1:105: CHANGE_GRAPH
                {
                mCHANGE_GRAPH(); 

                }
                break;
            case 12 :
                // DGS.g:1:118: STEP
                {
                mSTEP(); 

                }
                break;
            case 13 :
                // DGS.g:1:123: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 14 :
                // DGS.g:1:132: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 15 :
                // DGS.g:1:141: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 16 :
                // DGS.g:1:148: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 17 :
                // DGS.g:1:155: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 18 :
                // DGS.g:1:161: DOT
                {
                mDOT(); 

                }
                break;
            case 19 :
                // DGS.g:1:165: PLUS
                {
                mPLUS(); 

                }
                break;
            case 20 :
                // DGS.g:1:170: MINUS
                {
                mMINUS(); 

                }
                break;
            case 21 :
                // DGS.g:1:176: COLON
                {
                mCOLON(); 

                }
                break;
            case 22 :
                // DGS.g:1:182: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 23 :
                // DGS.g:1:188: UNDERSCORE
                {
                mUNDERSCORE(); 

                }
                break;
            case 24 :
                // DGS.g:1:199: SLASH
                {
                mSLASH(); 

                }
                break;
            case 25 :
                // DGS.g:1:205: LESS
                {
                mLESS(); 

                }
                break;
            case 26 :
                // DGS.g:1:210: MORE
                {
                mMORE(); 

                }
                break;
            case 27 :
                // DGS.g:1:215: DATE
                {
                mDATE(); 

                }
                break;
            case 28 :
                // DGS.g:1:220: HOUR
                {
                mHOUR(); 

                }
                break;
            case 29 :
                // DGS.g:1:225: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 30 :
                // DGS.g:1:236: WS
                {
                mWS(); 

                }
                break;
            case 31 :
                // DGS.g:1:239: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 32 :
                // DGS.g:1:247: EOL
                {
                mEOL(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\1\31\1\35\1\uffff\5\26\6\uffff\1\47\3\uffff\1\51\12\uffff"+
        "\1\26\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\3\uffff\1\26\10\uffff"+
        "\2\26\2\67\1\uffff";
    static final String DFA18_eofS =
        "\70\uffff";
    static final String DFA18_minS =
        "\1\11\1\55\1\60\1\uffff\1\107\3\145\1\164\6\uffff\1\60\3\uffff\1"+
        "\52\12\uffff\1\123\10\56\3\uffff\1\60\10\uffff\1\60\1\63\2\56\1"+
        "\uffff";
    static final String DFA18_maxS =
        "\1\175\1\72\1\71\1\uffff\1\107\3\156\1\164\6\uffff\1\71\3\uffff"+
        "\1\52\12\uffff\1\123\10\172\3\uffff\1\60\10\uffff\1\60\1\64\2\172"+
        "\1\uffff";
    static final String DFA18_acceptS =
        "\3\uffff\1\3\5\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\uffff\1\25"+
        "\1\26\1\27\1\uffff\1\31\1\32\1\35\1\36\1\40\1\1\1\2\1\34\1\33\1"+
        "\23\11\uffff\1\24\1\37\1\30\1\uffff\1\5\1\10\1\6\1\11\1\7\1\12\1"+
        "\13\1\14\4\uffff\1\4";
    static final String DFA18_specialS =
        "\70\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\27\1\30\2\uffff\1\30\22\uffff\1\27\1\uffff\1\3\10\uffff\1"+
            "\2\1\15\1\17\1\16\1\23\12\1\1\20\1\uffff\1\24\1\21\1\25\2\uffff"+
            "\3\26\1\4\26\26\1\11\1\uffff\1\12\1\uffff\1\22\1\uffff\1\5\1"+
            "\26\1\7\1\6\16\26\1\10\7\26\1\13\1\uffff\1\14",
            "\1\34\1\32\1\uffff\12\1\1\33",
            "\12\32",
            "",
            "\1\36",
            "\1\40\10\uffff\1\37",
            "\1\42\10\uffff\1\41",
            "\1\44\1\uffff\1\45\6\uffff\1\43",
            "\1\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\32",
            "",
            "",
            "",
            "\1\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\52",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "",
            "",
            "",
            "\1\63",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\64",
            "\1\65\1\66",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\26\1\uffff\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( NUMBER | REAL | STRING | DGS_MAGIC | ADD_NODE | DELETE_NODE | CHANGE_NODE | ADD_EDGE | DELETE_EDGE | CHANGE_EDGE | CHANGE_GRAPH | STEP | LBRACKET | RBRACKET | LBRACE | RBRACE | COMMA | DOT | PLUS | MINUS | COLON | EQUAL | UNDERSCORE | SLASH | LESS | MORE | DATE | HOUR | IDENTIFIER | WS | COMMENT | EOL );";
        }
    }
 

}