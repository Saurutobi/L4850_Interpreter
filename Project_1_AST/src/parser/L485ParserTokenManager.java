/* Generated By:JavaCC: Do not edit this line. L485ParserTokenManager.java */
package parser;
import abstractSyntaxTree.*;

/** Token Manager. */
public class L485ParserTokenManager implements L485ParserConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x4000000L) != 0L)
            return 0;
         if ((active0 & 0x7fffc0L) != 0L)
         {
            jjmatchedKind = 40;
            return 9;
         }
         return -1;
      case 1:
         if ((active0 & 0x77b7c0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 1;
            return 9;
         }
         if ((active0 & 0x84800L) != 0L)
            return 9;
         return -1;
      case 2:
         if ((active0 & 0x76b7c0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 2;
            return 9;
         }
         if ((active0 & 0x10000L) != 0L)
            return 9;
         return -1;
      case 3:
         if ((active0 & 0x4401c0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 3;
            return 9;
         }
         if ((active0 & 0x32b600L) != 0L)
            return 9;
         return -1;
      case 4:
         if ((active0 & 0x401c0L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 4;
            return 9;
         }
         if ((active0 & 0x400000L) != 0L)
            return 9;
         return -1;
      case 5:
         if ((active0 & 0x80L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 5;
            return 9;
         }
         if ((active0 & 0x40140L) != 0L)
            return 9;
         return -1;
      case 6:
         if ((active0 & 0x80L) != 0L)
         {
            jjmatchedKind = 40;
            jjmatchedPos = 6;
            return 9;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 29;
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 40:
         return jjStopAtPos(0, 46);
      case 41:
         return jjStopAtPos(0, 47);
      case 42:
         return jjStopAtPos(0, 25);
      case 43:
         return jjStopAtPos(0, 23);
      case 44:
         return jjStopAtPos(0, 52);
      case 45:
         jjmatchedKind = 24;
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      case 46:
         return jjStopAtPos(0, 45);
      case 47:
         return jjStartNfaWithStates_0(0, 26, 0);
      case 60:
         return jjMoveStringLiteralDfa1_0(0x300000000L);
      case 61:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 62:
         jjmatchedKind = 34;
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 91:
         return jjStopAtPos(0, 50);
      case 93:
         return jjStopAtPos(0, 51);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0xc0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x404200L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x281000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 123:
         return jjStopAtPos(0, 48);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x8000000L);
      case 125:
         return jjStopAtPos(0, 49);
      default :
         return jjMoveNfa_0(4, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 32:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         break;
      case 38:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         break;
      case 61:
         if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(1, 31);
         else if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(1, 33);
         else if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 35);
         break;
      case 62:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x420000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x101c0L);
      case 102:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(1, 11, 9);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 105:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(1, 14, 9);
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 111:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(1, 19, 9);
         return jjMoveStringLiteralDfa2_0(active0, 0x8400L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 124:
         if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(1, 27);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0xc0L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x600L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x42000L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x100100L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000L);
      case 119:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(2, 16, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 99:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(3, 9, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x80L);
      case 100:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 9);
         else if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(3, 15, 9);
         break;
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 9);
         else if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(3, 21, 9);
         break;
      case 104:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000L);
      case 110:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 9);
         break;
      case 115:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(3, 17, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(4, 22, 9);
         break;
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000L);
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x80L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x40L);
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0x100L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x80L);
      case 99:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(5, 6, 9);
         break;
      case 100:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(5, 8, 9);
         break;
      case 110:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(5, 18, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 115:
         return jjMoveStringLiteralDfa7_0(active0, 0x80L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 115:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(7, 7, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 22;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 44)
                        kind = 44;
                     jjCheckNAddStates(0, 3);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 44)
                        kind = 44;
                     jjCheckNAddTwoStates(11, 16);
                  }
                  else if (curChar == 39)
                     jjCheckNAddTwoStates(6, 7);
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 47)
                     jjCheckNAddStates(4, 6);
                  break;
               case 1:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(4, 6);
                  break;
               case 2:
                  if (curChar == 13)
                     jjCheckNAdd(3);
                  break;
               case 3:
                  if (curChar == 10 && kind > 5)
                     kind = 5;
                  break;
               case 5:
                  if (curChar == 39)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 6:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 7:
                  if (curChar == 39 && kind > 37)
                     kind = 37;
                  break;
               case 9:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 10:
                  if (curChar != 48)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjCheckNAddTwoStates(11, 16);
                  break;
               case 11:
                  if (curChar == 46)
                     jjCheckNAdd(12);
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 42)
                     kind = 42;
                  jjCheckNAddTwoStates(12, 13);
                  break;
               case 14:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(15);
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 42)
                     kind = 42;
                  jjCheckNAdd(15);
                  break;
               case 17:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(18);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 42)
                     kind = 42;
                  jjCheckNAdd(18);
                  break;
               case 19:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjCheckNAddStates(0, 3);
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(7, 9);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjCheckNAdd(21);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
               case 9:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 40)
                     kind = 40;
                  jjCheckNAdd(9);
                  break;
               case 1:
                  jjAddStates(4, 6);
                  break;
               case 6:
                  jjAddStates(10, 11);
                  break;
               case 13:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(12, 13);
                  break;
               case 16:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(14, 15);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(4, 6);
                  break;
               case 6:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(10, 11);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 22 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   20, 11, 16, 21, 1, 2, 3, 20, 11, 16, 6, 7, 14, 15, 17, 18, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, "\144\145\146\165\156\143", 
"\144\145\146\143\154\141\163\163", "\155\145\164\150\157\144", "\146\165\156\143", "\143\157\156\144", 
"\151\146", "\164\150\145\156", "\145\154\163\145", "\146\151", "\154\157\141\144", 
"\156\145\167", "\166\141\162\163", "\141\163\163\151\147\156", "\164\157", 
"\167\151\164\150", "\164\162\165\145", "\146\141\154\163\145", "\53", "\55", "\52", "\57", 
"\174\174", "\46\46", "\41", "\75\75", "\41\75", "\74\40", "\74\75", "\76", "\76\75", 
"\55\76", null, null, null, null, null, null, null, null, "\56", "\50", "\51", "\173", 
"\175", "\133", "\135", "\54", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x1ff53fffffffc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[22];
static private final int[] jjstateSet = new int[44];
static protected char curChar;
/** Constructor. */
public L485ParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public L485ParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 22; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
