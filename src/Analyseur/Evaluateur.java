/* Generated By:JavaCC: Do not edit this line. Evaluateur.java */
package Analyseur;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import SpreadSheet.*;

public class Evaluateur implements EvaluateurConstants {

        public static double resultParsing ;
        static Evaluateur parser = null;
        static SpreadSheet _sps;


    public static void Evaluer(String exp,int i, SpreadSheet sps) {
        try {
                java.io.StringReader sr = new java.io.StringReader( exp );
                        java.io.Reader r = new java.io.BufferedReader( sr );
                        if(i == 0){
                                parser = new Evaluateur( r );
                        }
                        else{
                                parser.ReInit(r);
                        }
                        _sps = sps;
                        resultParsing = parser.S();
        } catch (Throwable e) {
           JFrame _frame = new JFrame("Erreur");
           JOptionPane.showMessageDialog(_frame, "La cellule est vide!",
                                      "avertissement",
                                      JOptionPane.ERROR_MESSAGE);
                   resultParsing =-1;
        }
    }

/* S --> E<EOF> */
  static final public double S() throws ParseException {
             double res;
    res = E();
    jj_consume_token(0);
                 {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public double E() throws ParseException {
             double res1;
        double res2;
    res1 = T();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MOINS:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        res2 = T();
      res1 +=res2;
        break;
      case MOINS:
        jj_consume_token(MOINS);
        res2 = T();
      res1 -= res2;
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         {if (true) return res1;}
    throw new Error("Missing return statement in function");
  }

  static final public double T() throws ParseException {
             double res1;
        double res2;
    res1 = F();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
      case DIV:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
        jj_consume_token(MUL);
        res2 = F();
      res1 *=res2;
        break;
      case DIV:
        jj_consume_token(DIV);
        res2 = F();
      res1 /= res2;
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
         {if (true) return res1;}
    throw new Error("Missing return statement in function");
  }

  static final public double F() throws ParseException {
             double res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MOINS:
      jj_consume_token(MOINS);
      res = ELEM();
      break;
    case PLUS:
      jj_consume_token(PLUS);
      res = ELEM();
      break;
    case PO:
    case SUM:
    case PROD:
    case MOY:
    case SIN:
    case COS:
    case TAN:
    case LOG:
    case LN:
    case POW:
    case SQRT:
    case ABS:
    case VAR:
    case E:
    case MIN:
    case MAX:
    case EcT:
    case AND:
    case OR:
    case NOT:
    case SI:
    case VRAI:
    case FAUX:
    case NOMBRE:
    case Cellule:
      res = ELEM();
         {if (true) return res;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public double ELEM() throws ParseException {
                double res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PO:
      jj_consume_token(PO);
      res = E();
      jj_consume_token(PF);
      break;
    case SUM:
    case PROD:
    case MOY:
    case SIN:
    case COS:
    case TAN:
    case LOG:
    case LN:
    case POW:
    case SQRT:
    case ABS:
    case VAR:
    case E:
    case MIN:
    case MAX:
    case EcT:
    case AND:
    case OR:
    case NOT:
    case SI:
    case VRAI:
    case FAUX:
    case NOMBRE:
    case Cellule:
      res = EXP();
         {if (true) return res;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public double EXP() throws ParseException {
               double x; Token n;
        int row;
        int column;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOMBRE:
      n = jj_consume_token(NOMBRE);
                       {if (true) return Double.parseDouble(n.image);}
      break;
    case Cellule:
      n = jj_consume_token(Cellule);
                row =CellString.getColNum(CellString.getRowIndex(n.image)[0])-1;
        column = Integer.parseInt(CellString.getColumnName(n.image)[1])-1;
                SheetCell sc = (SheetCell)_sps.getValueAt(row, column);
       x= Double.parseDouble((String)sc.getValue());
       {if (true) return x;}
      break;
    case SUM:
    case PROD:
    case MOY:
    case SIN:
    case COS:
    case TAN:
    case LOG:
    case LN:
    case POW:
    case SQRT:
    case ABS:
      x = MATH();
                       {if (true) return x;}
      break;
    case VAR:
    case E:
    case MIN:
    case MAX:
    case EcT:
      x = STAT();
                       {if (true) return x;}
      break;
    case AND:
    case OR:
    case NOT:
    case SI:
    case VRAI:
    case FAUX:
      x = LOGIQUE();
                          {if (true) return x;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public double STAT() throws ParseException {
        ArrayList<Double > List = new ArrayList<Double >();
        double ex;
        double var;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      jj_consume_token(VAR);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
          ex = 0;
          var = 0;
      for(int i=0 ; i<List.size() ; i++) ex = ex + List.get(i);
      ex /= List.size();
      for(int i=0 ; i<List.size() ; i++) var += (List.get(i) - ex)*(List.get(i) - ex);
      {if (true) return var/(List.size()-1);}
      break;
    case E:
      jj_consume_token(E);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
          ex = 0;
          for(int i=0 ; i<List.size() ; i++) ex = ex + List.get(i);
      ex /= List.size();
      {if (true) return ex;}
      break;
    case EcT:
      jj_consume_token(EcT);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
          ex = 0;
          var = 0;
      for(int i=0 ; i<List.size() ; i++) ex = ex + List.get(i);
      ex /= List.size();
      for(int i=0 ; i<List.size() ; i++) var += (List.get(i) - ex)*(List.get(i) - ex);
      {if (true) return Math.sqrt(var);}
      break;
    case MAX:
      jj_consume_token(MAX);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
          ex = List.get(0);
      for(int i=1 ; i<List.size() ; i++) {
        if ( ex < List.get(i) ) ex = List.get(i);
      }
      {if (true) return ex;}
      break;
    case MIN:
      jj_consume_token(MIN);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
          ex = List.get(0);
      for(int i=1 ; i<List.size() ; i++) {
        if ( ex > List.get(i) ) ex = List.get(i);
      }
      {if (true) return ex;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public double LOGIQUE() throws ParseException {
                  Token n;
        ArrayList<Double > List = new ArrayList<Double >();
        double res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
      jj_consume_token(AND);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
      res = 1;
      for(int i=0 ; i<List.size() ; i++) {
        if ( List.get(i) != 0 && List.get(i) != 1 ){
                {if (true) return -1;}
        }else{
                      if ( List.get(i) == 0 ){
                        {if (true) return 0;}
                      }
        }
      }
      {if (true) return res;}
      break;
    case OR:
      jj_consume_token(OR);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
      res = 0;
      for(int i=0 ; i<List.size() ; i++) {
        if ( List.get(i) != 0 && List.get(i) != 1 ){
                {if (true) return -1;}
        }else{
                      if ( List.get(i) == 1 ){
                        {if (true) return 1;}
                      }
        }
      }
      {if (true) return res;}
      break;
    case NOT:
      jj_consume_token(NOT);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
        if ( res != 0 && res != 1 ){
                {if (true) return -1;}
        }else{
                      if ( res == 1 ){
                        {if (true) return 0;}
                      }else{
                        {if (true) return 1;}
                      }
        }
      break;
    case VRAI:
      n = jj_consume_token(VRAI);
                 {if (true) return 1;}
      break;
    case FAUX:
      n = jj_consume_token(FAUX);
                    {if (true) return 0;}
      break;
    case SI:
      res = FonctionSi();
                        {if (true) return res;}
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public double FonctionSi() throws ParseException {
                     double res;
        double v1;
        double v2;
    jj_consume_token(SI);
    jj_consume_token(PO);
    jj_consume_token(PO);
    res = Condition();
    jj_consume_token(PF);
    jj_consume_token(PV);
    v1 = Arg();
    jj_consume_token(PV);
    v2 = Arg();
    jj_consume_token(PF);
                if ( res == 1) {{if (true) return v1;}}
                if ( res == 0) {{if (true) return v2;}}
    throw new Error("Missing return statement in function");
  }

  static final public double Condition() throws ParseException {
                    double res = -1;
        double v1;
        double v2;
    v1 = Arg();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUAL:
      case LESS:
      case GT:
      case LEQ:
      case GEQ:
      case DIF:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LESS:
        jj_consume_token(LESS);
        v2 = Arg();
                        if ( v1 < v2 ) {{if (true) return 1;}}
                        else {{if (true) return 0;}}
        break;
      case GT:
        jj_consume_token(GT);
        v2 = Arg();
                        if ( v1 > v2 ) {{if (true) return 1;}}
                        else {{if (true) return 0;}}
        break;
      case LEQ:
        jj_consume_token(LEQ);
        v2 = Arg();
                        if ( v1 <= v2 ) {{if (true) return 1;}}
                        else {{if (true) return 0;}}
        break;
      case GEQ:
        jj_consume_token(GEQ);
        v2 = Arg();
                        if ( v1 >= v2 ) {{if (true) return 1;}}
                        else {{if (true) return 0;}}
        break;
      case DIF:
        jj_consume_token(DIF);
        v2 = Arg();
                        if ( v1 != v2 ) {{if (true) return 1;}}
                        else {{if (true) return 0;}}
        break;
      case EQUAL:
        jj_consume_token(EQUAL);
        v2 = Arg();
                        if ( v1 == v2 ) {{if (true) return 1;}}
                        else {{if (true) return 0;}}
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
                        if (res == -1) {{if (true) return v1;}}
    throw new Error("Missing return statement in function");
  }

  static final public double MATH() throws ParseException {
        ArrayList<Double > List = new ArrayList<Double >();
        double res;
        double p;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SIN:
      jj_consume_token(SIN);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
                res = Math.sin(res);
                {if (true) return res;}
      break;
    case COS:
      jj_consume_token(COS);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
                res = Math.cos(res);
                {if (true) return res;}
      break;
    case TAN:
      jj_consume_token(TAN);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
                res = Math.tan(res);
                {if (true) return res;}
      break;
    case LOG:
      jj_consume_token(LOG);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
                res = Math.log(res)/10;
                {if (true) return res;}
      break;
    case LN:
      jj_consume_token(LN);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
                res = Math.log(res);
                {if (true) return res;}
      break;
    case SQRT:
      jj_consume_token(SQRT);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
                res = Math.sqrt(res);
                {if (true) return res;}
      break;
    case ABS:
      jj_consume_token(ABS);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PF);
                res = Math.abs(res);
                {if (true) return res;}
      break;
    case POW:
      jj_consume_token(POW);
      jj_consume_token(PO);
      res = Arg();
      jj_consume_token(PV);
      p = Arg();
      jj_consume_token(PF);
                res =Math.pow(res,p);
                {if (true) return res;}
      break;
    case SUM:
      jj_consume_token(SUM);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
      res = 0;
      for(int i=0 ; i<List.size() ; i++) res = res + List.get(i);
      {if (true) return res;}
      break;
    case PROD:
      jj_consume_token(PROD);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
      res = 1;
      for(int i=0 ; i<List.size() ; i++) res = res * List.get(i);
      {if (true) return res;}
      break;
    case MOY:
      jj_consume_token(MOY);
      jj_consume_token(PO);
      List = ListeArg();
      jj_consume_token(PF);
      res = 0;
      for(int i=0 ; i<List.size() ; i++) res = res + List.get(i);
      {if (true) return res/List.size();}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Double > ListeArg() throws ParseException, NumberFormatException {
  ArrayList<Double > List = new ArrayList<Double >();
  double val=0;
    val = EXP();
      List.add(val);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PV:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_4;
      }
      jj_consume_token(PV);
      val = EXP();
        List.add(val);
    }
      {if (true) return List ;}
    throw new Error("Missing return statement in function");
  }

  static final public double Arg() throws ParseException {
              double res = 0;
    res = E();
                   {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  static public EvaluateurTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  static public Token token, jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_0();
      jj_la1_1();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0xc0,0xc0,0x300,0x300,0xfffe00d0,0xfffe0010,0xfffe0000,0xf0000000,0x0,0x1f800,0x1f800,0xffe0000,0x400,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x4ff,0x4ff,0x4ff,0x1,0x7e,0x0,0x0,0x0,0x0,};
   }

  public Evaluateur(java.io.InputStream stream) {
     this(stream, null);
  }
  public Evaluateur(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new EvaluateurTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public Evaluateur(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new EvaluateurTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public Evaluateur(EvaluateurTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  You must");
      System.out.println("       either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  public void ReInit(EvaluateurTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  static final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.Vector<int[]> jj_expentries = new java.util.Vector<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  static public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[43];
    for (int i = 0; i < 43; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  static final public void enable_tracing() {
  }

  static final public void disable_tracing() {
  }

}
