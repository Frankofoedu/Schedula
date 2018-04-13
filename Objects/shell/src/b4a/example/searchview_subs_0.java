package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class searchview_subs_0 {


public static RemoteObject  _additemstolist(RemoteObject __ref,RemoteObject _li,RemoteObject _full) throws Exception{
try {
		Debug.PushSubsStack("AddItemsToList (searchview) ","searchview",4,__ref.getField(false, "ba"),__ref,70);
if (RapidSub.canDelegate("additemstolist")) return __ref.runUserSub(false, "searchview","additemstolist", __ref, _li, _full);
RemoteObject _it = RemoteObject.declareNull("b4a.example.searchview._item");
Debug.locals.put("li", _li);
Debug.locals.put("full", _full);
 BA.debugLineNum = 70;BA.debugLine="Private Sub AddItemsToList(li As List, full As Str";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="If li.IsInitialized = False Then Return";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_li.runMethod(true,"IsInitialized"),searchview.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 72;BA.debugLine="For Each it As Item In li";
Debug.ShouldStop(128);
{
final RemoteObject group2 = _li;
final int groupLen2 = group2.runMethod(true,"getSize").<Integer>get()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_it = (group2.runMethod(false,"Get",index2));Debug.locals.put("it", _it);
Debug.locals.put("it", _it);
 BA.debugLineNum = 73;BA.debugLine="If full.Length > MAX_LIMIT And it.SearchText.Con";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(">",_full.runMethod(true,"length"),BA.numberCast(double.class, __ref.getField(true,"_max_limit"))) && RemoteObject.solveBoolean("=",_it.getField(true,"SearchText").runMethod(true,"contains",(Object)(_full)),searchview.__c.getField(true,"False"))) { 
 BA.debugLineNum = 74;BA.debugLine="Continue";
Debug.ShouldStop(512);
if (true) continue;
 };
 BA.debugLineNum = 76;BA.debugLine="lv.AddTwoLines2(it.Title, it.Text, it)";
Debug.ShouldStop(2048);
__ref.getField(false,"_lv").runVoidMethod ("AddTwoLines2",(Object)(BA.ObjectToCharSequence(_it.getField(true,"Title"))),(Object)(BA.ObjectToCharSequence(_it.getField(true,"Text"))),(Object)((_it)));
 }
}Debug.locals.put("it", _it);
;
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtoparent(RemoteObject __ref,RemoteObject _parent,RemoteObject _left,RemoteObject _top,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("AddToParent (searchview) ","searchview",4,__ref.getField(false, "ba"),__ref,35);
if (RapidSub.canDelegate("addtoparent")) return __ref.runUserSub(false, "searchview","addtoparent", __ref, _parent, _left, _top, _width, _height);
Debug.locals.put("Parent", _parent);
Debug.locals.put("Left", _left);
Debug.locals.put("Top", _top);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 35;BA.debugLine="Public Sub AddToParent(Parent As Panel, Left As In";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Parent.AddView(et, Left, Top, Width, 60dip)";
Debug.ShouldStop(8);
_parent.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_et").getObject())),(Object)(_left),(Object)(_top),(Object)(_width),(Object)(searchview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))));
 BA.debugLineNum = 37;BA.debugLine="Parent.AddView(lv, Left, Top + et.Height, Width,";
Debug.ShouldStop(16);
_parent.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_lv").getObject())),(Object)(_left),(Object)(RemoteObject.solve(new RemoteObject[] {_top,__ref.getField(false,"_et").runMethod(true,"getHeight")}, "+",1, 1)),(Object)(_width),(Object)(RemoteObject.solve(new RemoteObject[] {_height,__ref.getField(false,"_et").runMethod(true,"getHeight")}, "-",1, 1)));
 BA.debugLineNum = 38;BA.debugLine="et_TextChanged(\"\", \"\")";
Debug.ShouldStop(32);
__ref.runClassMethod (b4a.example.searchview.class, "_et_textchanged",(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private prefixList As Map";
searchview._prefixlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_prefixlist",searchview._prefixlist);
 //BA.debugLineNum = 5;BA.debugLine="Private substringList As Map";
searchview._substringlist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_substringlist",searchview._substringlist);
 //BA.debugLineNum = 6;BA.debugLine="Private et As EditText";
searchview._et = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");__ref.setField("_et",searchview._et);
 //BA.debugLineNum = 7;BA.debugLine="Private lv As ListView";
searchview._lv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");__ref.setField("_lv",searchview._lv);
 //BA.debugLineNum = 8;BA.debugLine="Private MIN_LIMIT, MAX_LIMIT As Int";
searchview._min_limit = RemoteObject.createImmutable(0);__ref.setField("_min_limit",searchview._min_limit);
searchview._max_limit = RemoteObject.createImmutable(0);__ref.setField("_max_limit",searchview._max_limit);
 //BA.debugLineNum = 9;BA.debugLine="MIN_LIMIT = 1";
__ref.setField ("_min_limit",BA.numberCast(int.class, 1));
 //BA.debugLineNum = 10;BA.debugLine="MAX_LIMIT = 4 'doesn't limit the words length. On";
__ref.setField ("_max_limit",BA.numberCast(int.class, 4));
 //BA.debugLineNum = 11;BA.debugLine="Private mCallback As Object";
searchview._mcallback = RemoteObject.createNew ("Object");__ref.setField("_mcallback",searchview._mcallback);
 //BA.debugLineNum = 12;BA.debugLine="Private mEventName As String";
searchview._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",searchview._meventname);
 //BA.debugLineNum = 13;BA.debugLine="Private allItems As List";
searchview._allitems = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_allitems",searchview._allitems);
 //BA.debugLineNum = 14;BA.debugLine="Private IME As IME";
searchview._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");__ref.setField("_ime",searchview._ime);
 //BA.debugLineNum = 15;BA.debugLine="Type Item (SearchText As String, Title As String,";
;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _et_textchanged(RemoteObject __ref,RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("et_TextChanged (searchview) ","searchview",4,__ref.getField(false, "ba"),__ref,52);
if (RapidSub.canDelegate("et_textchanged")) return __ref.runUserSub(false, "searchview","et_textchanged", __ref, _old, _new);
RemoteObject _str1 = RemoteObject.createImmutable("");
RemoteObject _str2 = RemoteObject.createImmutable("");
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 52;BA.debugLine="Private Sub et_TextChanged (Old As String, New As";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="lv.Clear";
Debug.ShouldStop(1048576);
__ref.getField(false,"_lv").runVoidMethod ("Clear");
 BA.debugLineNum = 54;BA.debugLine="If lv.Visible = False Then lv.Visible = True";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_lv").runMethod(true,"getVisible"),searchview.__c.getField(true,"False"))) { 
__ref.getField(false,"_lv").runMethod(true,"setVisible",searchview.__c.getField(true,"True"));};
 BA.debugLineNum = 55;BA.debugLine="If New.Length < MIN_LIMIT Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("<",_new.runMethod(true,"length"),BA.numberCast(double.class, __ref.getField(true,"_min_limit")))) { 
 BA.debugLineNum = 56;BA.debugLine="AddItemsToList(allItems, \"\")";
Debug.ShouldStop(8388608);
__ref.runClassMethod (b4a.example.searchview.class, "_additemstolist",(Object)(__ref.getField(false,"_allitems")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 57;BA.debugLine="Return";
Debug.ShouldStop(16777216);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 59;BA.debugLine="Dim str1, str2 As String";
Debug.ShouldStop(67108864);
_str1 = RemoteObject.createImmutable("");Debug.locals.put("str1", _str1);
_str2 = RemoteObject.createImmutable("");Debug.locals.put("str2", _str2);
 BA.debugLineNum = 60;BA.debugLine="str1 = New.ToLowerCase";
Debug.ShouldStop(134217728);
_str1 = _new.runMethod(true,"toLowerCase");Debug.locals.put("str1", _str1);
 BA.debugLineNum = 61;BA.debugLine="If str1.Length > MAX_LIMIT Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(">",_str1.runMethod(true,"length"),BA.numberCast(double.class, __ref.getField(true,"_max_limit")))) { 
 BA.debugLineNum = 62;BA.debugLine="str2 = str1.SubString2(0, MAX_LIMIT)";
Debug.ShouldStop(536870912);
_str2 = _str1.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(true,"_max_limit")));Debug.locals.put("str2", _str2);
 }else {
 BA.debugLineNum = 64;BA.debugLine="str2 = str1";
Debug.ShouldStop(-2147483648);
_str2 = _str1;Debug.locals.put("str2", _str2);
 };
 BA.debugLineNum = 66;BA.debugLine="AddItemsToList(prefixList.Get(str2), str1)";
Debug.ShouldStop(2);
__ref.runClassMethod (b4a.example.searchview.class, "_additemstolist",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), __ref.getField(false,"_prefixlist").runMethod(false,"Get",(Object)((_str2)))),(Object)(_str1));
 BA.debugLineNum = 67;BA.debugLine="AddItemsToList(substringList.Get(str2), str1)";
Debug.ShouldStop(4);
__ref.runClassMethod (b4a.example.searchview.class, "_additemstolist",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), __ref.getField(false,"_substringlist").runMethod(false,"Get",(Object)((_str2)))),(Object)(_str1));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callback,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (searchview) ","searchview",4,__ref.getField(false, "ba"),__ref,19);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "searchview","initialize", __ref, _ba, _callback, _eventname);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Callback", _callback);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 19;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="IME.Initialize(\"\")";
Debug.ShouldStop(524288);
__ref.getField(false,"_ime").runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 21;BA.debugLine="et.Initialize(\"et\")";
Debug.ShouldStop(1048576);
__ref.getField(false,"_et").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("et")));
 BA.debugLineNum = 23;BA.debugLine="et.InputType = Bit.Or(et.INPUT_TYPE_TEXT, 0x00080";
Debug.ShouldStop(4194304);
__ref.getField(false,"_et").runMethod(true,"setInputType",searchview.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(__ref.getField(false,"_et").getField(true,"INPUT_TYPE_TEXT")),(Object)(BA.numberCast(int.class, 0x00080000))));
 BA.debugLineNum = 24;BA.debugLine="lv.Initialize(\"lv\")";
Debug.ShouldStop(8388608);
__ref.getField(false,"_lv").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("lv")));
 BA.debugLineNum = 25;BA.debugLine="lv.SingleLineLayout.ItemHeight = 50dip";
Debug.ShouldStop(16777216);
__ref.getField(false,"_lv").runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",searchview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))));
 BA.debugLineNum = 26;BA.debugLine="lv.SingleLineLayout.Label.TextSize = 14";
Debug.ShouldStop(33554432);
__ref.getField(false,"_lv").runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 14));
 BA.debugLineNum = 27;BA.debugLine="lv.Visible = False";
Debug.ShouldStop(67108864);
__ref.getField(false,"_lv").runMethod(true,"setVisible",searchview.__c.getField(true,"False"));
 BA.debugLineNum = 28;BA.debugLine="prefixList.Initialize";
Debug.ShouldStop(134217728);
__ref.getField(false,"_prefixlist").runVoidMethod ("Initialize");
 BA.debugLineNum = 29;BA.debugLine="substringList.Initialize";
Debug.ShouldStop(268435456);
__ref.getField(false,"_substringlist").runVoidMethod ("Initialize");
 BA.debugLineNum = 30;BA.debugLine="mCallback = Callback";
Debug.ShouldStop(536870912);
__ref.setField ("_mcallback",_callback);
 BA.debugLineNum = 31;BA.debugLine="mEventName = EventName";
Debug.ShouldStop(1073741824);
__ref.setField ("_meventname",_eventname);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lv_itemclick(RemoteObject __ref,RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("lv_ItemClick (searchview) ","searchview",4,__ref.getField(false, "ba"),__ref,41);
if (RapidSub.canDelegate("lv_itemclick")) return __ref.runUserSub(false, "searchview","lv_itemclick", __ref, _position, _value);
RemoteObject _it = RemoteObject.declareNull("b4a.example.searchview._item");
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 41;BA.debugLine="Private Sub lv_ItemClick (Position As Int, Value A";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Dim it As Item = Value";
Debug.ShouldStop(512);
_it = (_value);Debug.locals.put("it", _it);Debug.locals.put("it", _it);
 BA.debugLineNum = 43;BA.debugLine="et.Text = it.Title";
Debug.ShouldStop(1024);
__ref.getField(false,"_et").runMethodAndSync(true,"setText",BA.ObjectToCharSequence(_it.getField(true,"Title")));
 BA.debugLineNum = 44;BA.debugLine="et.SelectionStart = et.Text.Length";
Debug.ShouldStop(2048);
__ref.getField(false,"_et").runMethod(true,"setSelectionStart",__ref.getField(false,"_et").runMethod(true,"getText").runMethod(true,"length"));
 BA.debugLineNum = 45;BA.debugLine="IME.HideKeyboard";
Debug.ShouldStop(4096);
__ref.getField(false,"_ime").runVoidMethod ("HideKeyboard",__ref.getField(false, "ba"));
 BA.debugLineNum = 46;BA.debugLine="lv.Visible = False";
Debug.ShouldStop(8192);
__ref.getField(false,"_lv").runMethod(true,"setVisible",searchview.__c.getField(true,"False"));
 BA.debugLineNum = 47;BA.debugLine="If SubExists(mCallback, mEventName & \"_ItemClick\"";
Debug.ShouldStop(16384);
if (searchview.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mcallback")),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname"),RemoteObject.createImmutable("_ItemClick")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 48;BA.debugLine="CallSub2(mCallback, mEventName & \"_ItemClick\", i";
Debug.ShouldStop(32768);
searchview.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mcallback")),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname"),RemoteObject.createImmutable("_ItemClick"))),(Object)(_it.getField(false,"Value")));
 };
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setindex(RemoteObject __ref,RemoteObject _index,RemoteObject _items) throws Exception{
try {
		Debug.PushSubsStack("SetIndex (searchview) ","searchview",4,__ref.getField(false, "ba"),__ref,122);
if (RapidSub.canDelegate("setindex")) return __ref.runUserSub(false, "searchview","setindex", __ref, _index, _items);
RemoteObject _obj = null;
Debug.locals.put("Index", _index);
Debug.locals.put("Items", _items);
 BA.debugLineNum = 122;BA.debugLine="Public Sub SetIndex(Index As Object, Items As List";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="Dim obj() As Object";
Debug.ShouldStop(67108864);
_obj = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("obj", _obj);
 BA.debugLineNum = 124;BA.debugLine="obj = Index";
Debug.ShouldStop(134217728);
_obj = (_index);Debug.locals.put("obj", _obj);
 BA.debugLineNum = 125;BA.debugLine="prefixList = obj(0)";
Debug.ShouldStop(268435456);
__ref.getField(false,"_prefixlist").setObject (_obj.getArrayElement(false,BA.numberCast(int.class, 0)));
 BA.debugLineNum = 126;BA.debugLine="substringList = obj(1)";
Debug.ShouldStop(536870912);
__ref.getField(false,"_substringlist").setObject (_obj.getArrayElement(false,BA.numberCast(int.class, 1)));
 BA.debugLineNum = 127;BA.debugLine="allItems = Items";
Debug.ShouldStop(1073741824);
__ref.setField ("_allitems",_items);
 BA.debugLineNum = 128;BA.debugLine="AddItemsToList(allItems, \"\")";
Debug.ShouldStop(-2147483648);
__ref.runClassMethod (b4a.example.searchview.class, "_additemstolist",(Object)(__ref.getField(false,"_allitems")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setitems(RemoteObject __ref,RemoteObject _items) throws Exception{
try {
		Debug.PushSubsStack("SetItems (searchview) ","searchview",4,__ref.getField(false, "ba"),__ref,82);
if (RapidSub.canDelegate("setitems")) return __ref.runUserSub(false, "searchview","setitems", __ref, _items);
RemoteObject _starttime = RemoteObject.createImmutable(0L);
RemoteObject _noduplicates = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _li = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _it = RemoteObject.declareNull("b4a.example.searchview._item");
int _start = 0;
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _str = RemoteObject.createImmutable("");
Debug.locals.put("Items", _items);
 BA.debugLineNum = 82;BA.debugLine="Public Sub SetItems(Items As List) As Object";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="allItems = Items";
Debug.ShouldStop(262144);
__ref.setField ("_allitems",_items);
 BA.debugLineNum = 84;BA.debugLine="AddItemsToList(allItems, \"\")";
Debug.ShouldStop(524288);
__ref.runClassMethod (b4a.example.searchview.class, "_additemstolist",(Object)(__ref.getField(false,"_allitems")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 85;BA.debugLine="Dim startTime As Long";
Debug.ShouldStop(1048576);
_starttime = RemoteObject.createImmutable(0L);Debug.locals.put("startTime", _starttime);
 BA.debugLineNum = 86;BA.debugLine="startTime = DateTime.Now";
Debug.ShouldStop(2097152);
_starttime = searchview.__c.getField(false,"DateTime").runMethod(true,"getNow");Debug.locals.put("startTime", _starttime);
 BA.debugLineNum = 88;BA.debugLine="Dim noDuplicates As Map";
Debug.ShouldStop(8388608);
_noduplicates = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("noDuplicates", _noduplicates);
 BA.debugLineNum = 89;BA.debugLine="noDuplicates.Initialize";
Debug.ShouldStop(16777216);
_noduplicates.runVoidMethod ("Initialize");
 BA.debugLineNum = 90;BA.debugLine="prefixList.Clear";
Debug.ShouldStop(33554432);
__ref.getField(false,"_prefixlist").runVoidMethod ("Clear");
 BA.debugLineNum = 91;BA.debugLine="substringList.Clear";
Debug.ShouldStop(67108864);
__ref.getField(false,"_substringlist").runVoidMethod ("Clear");
 BA.debugLineNum = 92;BA.debugLine="Dim m As Map";
Debug.ShouldStop(134217728);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 93;BA.debugLine="Dim li As List";
Debug.ShouldStop(268435456);
_li = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("li", _li);
 BA.debugLineNum = 94;BA.debugLine="For Each it As Item In Items";
Debug.ShouldStop(536870912);
{
final RemoteObject group11 = _items;
final int groupLen11 = group11.runMethod(true,"getSize").<Integer>get()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_it = (group11.runMethod(false,"Get",index11));Debug.locals.put("it", _it);
Debug.locals.put("it", _it);
 BA.debugLineNum = 95;BA.debugLine="noDuplicates.Clear";
Debug.ShouldStop(1073741824);
_noduplicates.runVoidMethod ("Clear");
 BA.debugLineNum = 96;BA.debugLine="For start = 0 To it.SearchText.Length";
Debug.ShouldStop(-2147483648);
{
final int step13 = 1;
final int limit13 = _it.getField(true,"SearchText").runMethod(true,"length").<Integer>get().intValue();
_start = 0 ;
for (;(step13 > 0 && _start <= limit13) || (step13 < 0 && _start >= limit13) ;_start = ((int)(0 + _start + step13))  ) {
Debug.locals.put("start", _start);
 BA.debugLineNum = 97;BA.debugLine="Dim count As Int";
Debug.ShouldStop(1);
_count = RemoteObject.createImmutable(0);Debug.locals.put("count", _count);
 BA.debugLineNum = 98;BA.debugLine="count = MIN_LIMIT";
Debug.ShouldStop(2);
_count = __ref.getField(true,"_min_limit");Debug.locals.put("count", _count);
 BA.debugLineNum = 99;BA.debugLine="Do While count <= MAX_LIMIT And start + count <";
Debug.ShouldStop(4);
while (RemoteObject.solveBoolean("k",_count,BA.numberCast(double.class, __ref.getField(true,"_max_limit"))) && RemoteObject.solveBoolean("k",RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_start),_count}, "+",1, 1),BA.numberCast(double.class, _it.getField(true,"SearchText").runMethod(true,"length")))) {
 BA.debugLineNum = 100;BA.debugLine="Dim str As String";
Debug.ShouldStop(8);
_str = RemoteObject.createImmutable("");Debug.locals.put("str", _str);
 BA.debugLineNum = 101;BA.debugLine="str = it.SearchText.SubString2(start, start +";
Debug.ShouldStop(16);
_str = _it.getField(true,"SearchText").runMethod(true,"substring",(Object)(BA.numberCast(int.class, _start)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_start),_count}, "+",1, 1)));Debug.locals.put("str", _str);
 BA.debugLineNum = 102;BA.debugLine="If noDuplicates.ContainsKey(str) = False Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_noduplicates.runMethod(true,"ContainsKey",(Object)((_str))),searchview.__c.getField(true,"False"))) { 
 BA.debugLineNum = 103;BA.debugLine="noDuplicates.Put(str, \"\")";
Debug.ShouldStop(64);
_noduplicates.runVoidMethod ("Put",(Object)((_str)),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 104;BA.debugLine="If start = 0 Then m = prefixList Else m = sub";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_start),BA.numberCast(double.class, 0))) { 
_m = __ref.getField(false,"_prefixlist");Debug.locals.put("m", _m);}
else {
_m = __ref.getField(false,"_substringlist");Debug.locals.put("m", _m);};
 BA.debugLineNum = 105;BA.debugLine="li = m.Get(str)";
Debug.ShouldStop(256);
_li.setObject(_m.runMethod(false,"Get",(Object)((_str))));
 BA.debugLineNum = 106;BA.debugLine="If li.IsInitialized = False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_li.runMethod(true,"IsInitialized"),searchview.__c.getField(true,"False"))) { 
 BA.debugLineNum = 107;BA.debugLine="li.Initialize";
Debug.ShouldStop(1024);
_li.runVoidMethod ("Initialize");
 BA.debugLineNum = 108;BA.debugLine="m.Put(str, li)";
Debug.ShouldStop(2048);
_m.runVoidMethod ("Put",(Object)((_str)),(Object)((_li.getObject())));
 };
 BA.debugLineNum = 110;BA.debugLine="li.Add(it) 'Preserve the original case";
Debug.ShouldStop(8192);
_li.runVoidMethod ("Add",(Object)((_it)));
 };
 BA.debugLineNum = 112;BA.debugLine="count = count + 1";
Debug.ShouldStop(32768);
_count = RemoteObject.solve(new RemoteObject[] {_count,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("count", _count);
 }
;
 }
}Debug.locals.put("start", _start);
;
 }
}Debug.locals.put("it", _it);
;
 BA.debugLineNum = 116;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(524288);
searchview.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 117;BA.debugLine="Log(\"Index time: \" & (DateTime.Now - startTime) &";
Debug.ShouldStop(1048576);
searchview.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Index time: "),(RemoteObject.solve(new RemoteObject[] {searchview.__c.getField(false,"DateTime").runMethod(true,"getNow"),_starttime}, "-",1, 2)),RemoteObject.createImmutable(" ms ("),_items.runMethod(true,"getSize"),RemoteObject.createImmutable(" Items)"))));
 BA.debugLineNum = 118;BA.debugLine="Return Array As Object(prefixList, substringList)";
Debug.ShouldStop(2097152);
if (true) return (RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(__ref.getField(false,"_prefixlist").getObject()),(__ref.getField(false,"_substringlist").getObject())}));
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}