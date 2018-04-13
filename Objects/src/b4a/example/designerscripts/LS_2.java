package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_2{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[2/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="ImageView3.Left = PnlAdd.Width / 2"[2/General script]
views.get("imageview3").vw.setLeft((int)((views.get("pnladd").vw.getWidth())/2d));
//BA.debugLineNum = 4;BA.debugLine="LblDate.Left = (PnlAdd.Width / 2) + ImageView3.Width + 5dip"[2/General script]
views.get("lbldate").vw.setLeft((int)(((views.get("pnladd").vw.getWidth())/2d)+(views.get("imageview3").vw.getWidth())+(5d * scale)));
//BA.debugLineNum = 5;BA.debugLine="LblTime.Left = ImageView2.Width + 15dip"[2/General script]
views.get("lbltime").vw.setLeft((int)((views.get("imageview2").vw.getWidth())+(15d * scale)));
//BA.debugLineNum = 6;BA.debugLine="panSend.Left = (PnlAdd.Width/2) - (panSend.Width/2)"[2/General script]
views.get("pansend").vw.setLeft((int)(((views.get("pnladd").vw.getWidth())/2d)-((views.get("pansend").vw.getWidth())/2d)));

}
}