package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class searchview extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.searchview");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.searchview.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _item{
public boolean IsInitialized;
public String SearchText;
public String Title;
public String Text;
public Object Value;
public void Initialize() {
IsInitialized = true;
SearchText = "";
Title = "";
Text = "";
Value = new Object();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _prefixlist = null;
public anywheresoftware.b4a.objects.collections.Map _substringlist = null;
public anywheresoftware.b4a.objects.EditTextWrapper _et = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lv = null;
public int _min_limit = 0;
public int _max_limit = 0;
public Object _mcallback = null;
public String _meventname = "";
public anywheresoftware.b4a.objects.collections.List _allitems = null;
public anywheresoftware.b4a.objects.IME _ime = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.messaging _messaging = null;
public b4a.example.add _add = null;
public String  _additemstolist(b4a.example.searchview __ref,anywheresoftware.b4a.objects.collections.List _li,String _full) throws Exception{
__ref = this;
RDebugUtils.currentModule="searchview";
if (Debug.shouldDelegate(ba, "additemstolist"))
	return (String) Debug.delegate(ba, "additemstolist", new Object[] {_li,_full});
b4a.example.searchview._item _it = null;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Private Sub AddItemsToList(li As List, full As Str";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="If li.IsInitialized = False Then Return";
if (_li.IsInitialized()==__c.False) { 
if (true) return "";};
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="For Each it As Item In li";
{
final anywheresoftware.b4a.BA.IterableList group2 = _li;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_it = (b4a.example.searchview._item)(group2.Get(index2));
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="If full.Length > MAX_LIMIT And it.SearchText.Con";
if (_full.length()>__ref._max_limit && _it.SearchText.contains(_full)==__c.False) { 
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="Continue";
if (true) continue;
 };
RDebugUtils.currentLine=2686982;
 //BA.debugLineNum = 2686982;BA.debugLine="lv.AddTwoLines2(it.Title, it.Text, it)";
__ref._lv.AddTwoLines2(BA.ObjectToCharSequence(_it.Title),BA.ObjectToCharSequence(_it.Text),(Object)(_it));
 }
};
RDebugUtils.currentLine=2686984;
 //BA.debugLineNum = 2686984;BA.debugLine="End Sub";
return "";
}
public String  _addtoparent(b4a.example.searchview __ref,anywheresoftware.b4a.objects.PanelWrapper _parent,int _left,int _top,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="searchview";
if (Debug.shouldDelegate(ba, "addtoparent"))
	return (String) Debug.delegate(ba, "addtoparent", new Object[] {_parent,_left,_top,_width,_height});
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Public Sub AddToParent(Parent As Panel, Left As In";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Parent.AddView(et, Left, Top, Width, 60dip)";
_parent.AddView((android.view.View)(__ref._et.getObject()),_left,_top,_width,__c.DipToCurrent((int) (60)));
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Parent.AddView(lv, Left, Top + et.Height, Width,";
_parent.AddView((android.view.View)(__ref._lv.getObject()),_left,(int) (_top+__ref._et.getHeight()),_width,(int) (_height-__ref._et.getHeight()));
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="et_TextChanged(\"\", \"\")";
__ref._et_textchanged(null,"","");
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="End Sub";
return "";
}
public String  _et_textchanged(b4a.example.searchview __ref,String _old,String _new) throws Exception{
__ref = this;
RDebugUtils.currentModule="searchview";
if (Debug.shouldDelegate(ba, "et_textchanged"))
	return (String) Debug.delegate(ba, "et_textchanged", new Object[] {_old,_new});
String _str1 = "";
String _str2 = "";
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Private Sub et_TextChanged (Old As String, New As";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="lv.Clear";
__ref._lv.Clear();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="If lv.Visible = False Then lv.Visible = True";
if (__ref._lv.getVisible()==__c.False) { 
__ref._lv.setVisible(__c.True);};
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="If New.Length < MIN_LIMIT Then";
if (_new.length()<__ref._min_limit) { 
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="AddItemsToList(allItems, \"\")";
__ref._additemstolist(null,__ref._allitems,"");
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="Dim str1, str2 As String";
_str1 = "";
_str2 = "";
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="str1 = New.ToLowerCase";
_str1 = _new.toLowerCase();
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="If str1.Length > MAX_LIMIT Then";
if (_str1.length()>__ref._max_limit) { 
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="str2 = str1.SubString2(0, MAX_LIMIT)";
_str2 = _str1.substring((int) (0),__ref._max_limit);
 }else {
RDebugUtils.currentLine=2621452;
 //BA.debugLineNum = 2621452;BA.debugLine="str2 = str1";
_str2 = _str1;
 };
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="AddItemsToList(prefixList.Get(str2), str1)";
__ref._additemstolist(null,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__ref._prefixlist.Get((Object)(_str2)))),_str1);
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="AddItemsToList(substringList.Get(str2), str1)";
__ref._additemstolist(null,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__ref._substringlist.Get((Object)(_str2)))),_str1);
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.example.searchview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="searchview";
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Private prefixList As Map";
_prefixlist = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Private substringList As Map";
_substringlist = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="Private et As EditText";
_et = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="Private lv As ListView";
_lv = new anywheresoftware.b4a.objects.ListViewWrapper();
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="Private MIN_LIMIT, MAX_LIMIT As Int";
_min_limit = 0;
_max_limit = 0;
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="MIN_LIMIT = 1";
__ref._min_limit = (int) (1);
RDebugUtils.currentLine=2359303;
 //BA.debugLineNum = 2359303;BA.debugLine="MAX_LIMIT = 4 'doesn't limit the words length. On";
__ref._max_limit = (int) (4);
RDebugUtils.currentLine=2359304;
 //BA.debugLineNum = 2359304;BA.debugLine="Private mCallback As Object";
_mcallback = new Object();
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="Private mEventName As String";
_meventname = "";
RDebugUtils.currentLine=2359306;
 //BA.debugLineNum = 2359306;BA.debugLine="Private allItems As List";
_allitems = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2359307;
 //BA.debugLineNum = 2359307;BA.debugLine="Private IME As IME";
_ime = new anywheresoftware.b4a.objects.IME();
RDebugUtils.currentLine=2359308;
 //BA.debugLineNum = 2359308;BA.debugLine="Type Item (SearchText As String, Title As String,";
;
RDebugUtils.currentLine=2359309;
 //BA.debugLineNum = 2359309;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.example.searchview __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="searchview";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname});
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="IME.Initialize(\"\")";
__ref._ime.Initialize("");
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="et.Initialize(\"et\")";
__ref._et.Initialize(ba,"et");
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="et.InputType = Bit.Or(et.INPUT_TYPE_TEXT, 0x00080";
__ref._et.setInputType(__c.Bit.Or(__ref._et.INPUT_TYPE_TEXT,(int) (0x00080000)));
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="lv.Initialize(\"lv\")";
__ref._lv.Initialize(ba,"lv");
RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="lv.SingleLineLayout.ItemHeight = 50dip";
__ref._lv.getSingleLineLayout().setItemHeight(__c.DipToCurrent((int) (50)));
RDebugUtils.currentLine=2424839;
 //BA.debugLineNum = 2424839;BA.debugLine="lv.SingleLineLayout.Label.TextSize = 14";
__ref._lv.getSingleLineLayout().Label.setTextSize((float) (14));
RDebugUtils.currentLine=2424840;
 //BA.debugLineNum = 2424840;BA.debugLine="lv.Visible = False";
__ref._lv.setVisible(__c.False);
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="prefixList.Initialize";
__ref._prefixlist.Initialize();
RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="substringList.Initialize";
__ref._substringlist.Initialize();
RDebugUtils.currentLine=2424843;
 //BA.debugLineNum = 2424843;BA.debugLine="mCallback = Callback";
__ref._mcallback = _callback;
RDebugUtils.currentLine=2424844;
 //BA.debugLineNum = 2424844;BA.debugLine="mEventName = EventName";
__ref._meventname = _eventname;
RDebugUtils.currentLine=2424845;
 //BA.debugLineNum = 2424845;BA.debugLine="End Sub";
return "";
}
public String  _lv_itemclick(b4a.example.searchview __ref,int _position,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="searchview";
if (Debug.shouldDelegate(ba, "lv_itemclick"))
	return (String) Debug.delegate(ba, "lv_itemclick", new Object[] {_position,_value});
b4a.example.searchview._item _it = null;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Private Sub lv_ItemClick (Position As Int, Value A";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim it As Item = Value";
_it = (b4a.example.searchview._item)(_value);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="et.Text = it.Title";
__ref._et.setText(BA.ObjectToCharSequence(_it.Title));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="et.SelectionStart = et.Text.Length";
__ref._et.setSelectionStart(__ref._et.getText().length());
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="IME.HideKeyboard";
__ref._ime.HideKeyboard(ba);
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="lv.Visible = False";
__ref._lv.setVisible(__c.False);
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="If SubExists(mCallback, mEventName & \"_ItemClick\"";
if (__c.SubExists(ba,__ref._mcallback,__ref._meventname+"_ItemClick")) { 
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="CallSub2(mCallback, mEventName & \"_ItemClick\", i";
__c.CallSubNew2(ba,__ref._mcallback,__ref._meventname+"_ItemClick",_it.Value);
 };
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="End Sub";
return "";
}
public String  _setindex(b4a.example.searchview __ref,Object _index,anywheresoftware.b4a.objects.collections.List _items) throws Exception{
__ref = this;
RDebugUtils.currentModule="searchview";
if (Debug.shouldDelegate(ba, "setindex"))
	return (String) Debug.delegate(ba, "setindex", new Object[] {_index,_items});
Object[] _obj = null;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Public Sub SetIndex(Index As Object, Items As List";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Dim obj() As Object";
_obj = new Object[(int) (0)];
{
int d0 = _obj.length;
for (int i0 = 0;i0 < d0;i0++) {
_obj[i0] = new Object();
}
}
;
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="obj = Index";
_obj = (Object[])(_index);
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="prefixList = obj(0)";
__ref._prefixlist.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_obj[(int) (0)]));
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="substringList = obj(1)";
__ref._substringlist.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_obj[(int) (1)]));
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="allItems = Items";
__ref._allitems = _items;
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="AddItemsToList(allItems, \"\")";
__ref._additemstolist(null,__ref._allitems,"");
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="End Sub";
return "";
}
public Object  _setitems(b4a.example.searchview __ref,anywheresoftware.b4a.objects.collections.List _items) throws Exception{
__ref = this;
RDebugUtils.currentModule="searchview";
if (Debug.shouldDelegate(ba, "setitems"))
	return (Object) Debug.delegate(ba, "setitems", new Object[] {_items});
long _starttime = 0L;
anywheresoftware.b4a.objects.collections.Map _noduplicates = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
anywheresoftware.b4a.objects.collections.List _li = null;
b4a.example.searchview._item _it = null;
int _start = 0;
int _count = 0;
String _str = "";
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Public Sub SetItems(Items As List) As Object";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="allItems = Items";
__ref._allitems = _items;
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="AddItemsToList(allItems, \"\")";
__ref._additemstolist(null,__ref._allitems,"");
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Dim startTime As Long";
_starttime = 0L;
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="startTime = DateTime.Now";
_starttime = __c.DateTime.getNow();
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="Dim noDuplicates As Map";
_noduplicates = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="noDuplicates.Initialize";
_noduplicates.Initialize();
RDebugUtils.currentLine=2752520;
 //BA.debugLineNum = 2752520;BA.debugLine="prefixList.Clear";
__ref._prefixlist.Clear();
RDebugUtils.currentLine=2752521;
 //BA.debugLineNum = 2752521;BA.debugLine="substringList.Clear";
__ref._substringlist.Clear();
RDebugUtils.currentLine=2752522;
 //BA.debugLineNum = 2752522;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="Dim li As List";
_li = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2752524;
 //BA.debugLineNum = 2752524;BA.debugLine="For Each it As Item In Items";
{
final anywheresoftware.b4a.BA.IterableList group11 = _items;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_it = (b4a.example.searchview._item)(group11.Get(index11));
RDebugUtils.currentLine=2752525;
 //BA.debugLineNum = 2752525;BA.debugLine="noDuplicates.Clear";
_noduplicates.Clear();
RDebugUtils.currentLine=2752526;
 //BA.debugLineNum = 2752526;BA.debugLine="For start = 0 To it.SearchText.Length";
{
final int step13 = 1;
final int limit13 = _it.SearchText.length();
_start = (int) (0) ;
for (;(step13 > 0 && _start <= limit13) || (step13 < 0 && _start >= limit13) ;_start = ((int)(0 + _start + step13))  ) {
RDebugUtils.currentLine=2752527;
 //BA.debugLineNum = 2752527;BA.debugLine="Dim count As Int";
_count = 0;
RDebugUtils.currentLine=2752528;
 //BA.debugLineNum = 2752528;BA.debugLine="count = MIN_LIMIT";
_count = __ref._min_limit;
RDebugUtils.currentLine=2752529;
 //BA.debugLineNum = 2752529;BA.debugLine="Do While count <= MAX_LIMIT And start + count <";
while (_count<=__ref._max_limit && _start+_count<=_it.SearchText.length()) {
RDebugUtils.currentLine=2752530;
 //BA.debugLineNum = 2752530;BA.debugLine="Dim str As String";
_str = "";
RDebugUtils.currentLine=2752531;
 //BA.debugLineNum = 2752531;BA.debugLine="str = it.SearchText.SubString2(start, start +";
_str = _it.SearchText.substring(_start,(int) (_start+_count));
RDebugUtils.currentLine=2752532;
 //BA.debugLineNum = 2752532;BA.debugLine="If noDuplicates.ContainsKey(str) = False Then";
if (_noduplicates.ContainsKey((Object)(_str))==__c.False) { 
RDebugUtils.currentLine=2752533;
 //BA.debugLineNum = 2752533;BA.debugLine="noDuplicates.Put(str, \"\")";
_noduplicates.Put((Object)(_str),(Object)(""));
RDebugUtils.currentLine=2752534;
 //BA.debugLineNum = 2752534;BA.debugLine="If start = 0 Then m = prefixList Else m = sub";
if (_start==0) { 
_m = __ref._prefixlist;}
else {
_m = __ref._substringlist;};
RDebugUtils.currentLine=2752535;
 //BA.debugLineNum = 2752535;BA.debugLine="li = m.Get(str)";
_li.setObject((java.util.List)(_m.Get((Object)(_str))));
RDebugUtils.currentLine=2752536;
 //BA.debugLineNum = 2752536;BA.debugLine="If li.IsInitialized = False Then";
if (_li.IsInitialized()==__c.False) { 
RDebugUtils.currentLine=2752537;
 //BA.debugLineNum = 2752537;BA.debugLine="li.Initialize";
_li.Initialize();
RDebugUtils.currentLine=2752538;
 //BA.debugLineNum = 2752538;BA.debugLine="m.Put(str, li)";
_m.Put((Object)(_str),(Object)(_li.getObject()));
 };
RDebugUtils.currentLine=2752540;
 //BA.debugLineNum = 2752540;BA.debugLine="li.Add(it) 'Preserve the original case";
_li.Add((Object)(_it));
 };
RDebugUtils.currentLine=2752542;
 //BA.debugLineNum = 2752542;BA.debugLine="count = count + 1";
_count = (int) (_count+1);
 }
;
 }
};
 }
};
RDebugUtils.currentLine=2752546;
 //BA.debugLineNum = 2752546;BA.debugLine="ProgressDialogHide";
__c.ProgressDialogHide();
RDebugUtils.currentLine=2752547;
 //BA.debugLineNum = 2752547;BA.debugLine="Log(\"Index time: \" & (DateTime.Now - startTime) &";
__c.Log("Index time: "+BA.NumberToString((__c.DateTime.getNow()-_starttime))+" ms ("+BA.NumberToString(_items.getSize())+" Items)");
RDebugUtils.currentLine=2752548;
 //BA.debugLineNum = 2752548;BA.debugLine="Return Array As Object(prefixList, substringList)";
if (true) return (Object)(new Object[]{(Object)(__ref._prefixlist.getObject()),(Object)(__ref._substringlist.getObject())});
RDebugUtils.currentLine=2752549;
 //BA.debugLineNum = 2752549;BA.debugLine="End Sub";
return null;
}
}