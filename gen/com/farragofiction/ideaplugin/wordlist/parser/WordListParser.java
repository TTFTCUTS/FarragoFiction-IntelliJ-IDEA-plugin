// This is a generated file. Not intended for manual editing.
package com.farragofiction.ideaplugin.wordlist.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.farragofiction.ideaplugin.wordlist.psi.WordListTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WordListParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == FILE_DEFAULT) {
      r = fileDefault(b, 0);
    }
    else if (t == FILE_INCLUDE) {
      r = fileInclude(b, 0);
    }
    else if (t == INDENT) {
      r = indent(b, 0);
    }
    else if (t == LIST) {
      r = list(b, 0);
    }
    else if (t == LIST_DEFAULT) {
      r = listDefault(b, 0);
    }
    else if (t == LIST_ENTRY) {
      r = listEntry(b, 0);
    }
    else if (t == LIST_ENTRY_TITLE) {
      r = listEntryTitle(b, 0);
    }
    else if (t == LIST_INCLUDE) {
      r = listInclude(b, 0);
    }
    else if (t == LIST_WEIGHT) {
      r = listWeight(b, 0);
    }
    else if (t == PROPERTY) {
      r = property(b, 0);
    }
    else if (t == VARIANT) {
      r = variant(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return wordListFile(b, l + 1);
  }

  /* ********************************************************** */
  // DEFAULT (KEY SEPARATOR VALUE)
  public static boolean fileDefault(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fileDefault")) return false;
    if (!nextTokenIs(b, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    r = r && fileDefault_1(b, l + 1);
    exit_section_(b, m, FILE_DEFAULT, r);
    return r;
  }

  // KEY SEPARATOR VALUE
  private static boolean fileDefault_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fileDefault_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEY, SEPARATOR, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INCLUDE FILENAME
  public static boolean fileInclude(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fileInclude")) return false;
    if (!nextTokenIs(b, INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INCLUDE, FILENAME);
    exit_section_(b, m, FILE_INCLUDE, r);
    return r;
  }

  /* ********************************************************** */
  // "    "
  public static boolean indent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indent")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INDENT, "<indent>");
    r = consumeToken(b, "    ");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // fileInclude|fileDefault|list|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fileInclude(b, l + 1);
    if (!r) r = fileDefault(b, l + 1);
    if (!r) r = list(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LISTNAME listDefault* (listInclude|listEntry)+
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, LISTNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LISTNAME);
    r = r && list_1(b, l + 1);
    r = r && list_2(b, l + 1);
    exit_section_(b, m, LIST, r);
    return r;
  }

  // listDefault*
  private static boolean list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!listDefault(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (listInclude|listEntry)+
  private static boolean list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = list_2_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // listInclude|listEntry
  private static boolean list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listInclude(b, l + 1);
    if (!r) r = listEntry(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // indent DEFAULT (KEY SEPARATOR VALUE)
  public static boolean listDefault(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listDefault")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_DEFAULT, "<list default>");
    r = indent(b, l + 1);
    r = r && consumeToken(b, DEFAULT);
    r = r && listDefault_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY SEPARATOR VALUE
  private static boolean listDefault_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listDefault_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEY, SEPARATOR, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // indent listEntryTitle variant*
  public static boolean listEntry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listEntry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_ENTRY, "<list entry>");
    r = indent(b, l + 1);
    r = r && listEntryTitle(b, l + 1);
    r = r && listEntry_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // variant*
  private static boolean listEntry_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listEntry_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!variant(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listEntry_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // property
  public static boolean listEntryTitle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listEntryTitle")) return false;
    if (!nextTokenIs(b, KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property(b, l + 1);
    exit_section_(b, m, LIST_ENTRY_TITLE, r);
    return r;
  }

  /* ********************************************************** */
  // indent INCLUDE listWeight
  public static boolean listInclude(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listInclude")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_INCLUDE, "<list include>");
    r = indent(b, l + 1);
    r = r && consumeToken(b, INCLUDE);
    r = r && listWeight(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (LISTNAME SEPARATOR VALUE) | LISTNAME
  public static boolean listWeight(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listWeight")) return false;
    if (!nextTokenIs(b, LISTNAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listWeight_0(b, l + 1);
    if (!r) r = consumeToken(b, LISTNAME);
    exit_section_(b, m, LIST_WEIGHT, r);
    return r;
  }

  // LISTNAME SEPARATOR VALUE
  private static boolean listWeight_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listWeight_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LISTNAME, SEPARATOR, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY SEPARATOR VALUE) | KEY
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    if (!nextTokenIs(b, KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, m, PROPERTY, r);
    return r;
  }

  // KEY SEPARATOR VALUE
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KEY, SEPARATOR, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // indent indent property
  public static boolean variant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIANT, "<variant>");
    r = indent(b, l + 1);
    r = r && indent(b, l + 1);
    r = r && property(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HEADER item_*
  static boolean wordListFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wordListFile")) return false;
    if (!nextTokenIs(b, HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEADER);
    r = r && wordListFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // item_*
  private static boolean wordListFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wordListFile_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wordListFile_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}
