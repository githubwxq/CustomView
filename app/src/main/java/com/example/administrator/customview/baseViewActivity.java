package com.example.administrator.customview;

import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.customview.View.PieData;
import com.example.administrator.customview.View.PieView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class baseViewActivity extends AppCompatActivity {
    PieView pv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_view);

        pv = (PieView) findViewById(R.id.pv);
        ArrayList<PieData> datas = new ArrayList<>();
        PieData a = new PieData("1111", 100);
        PieData b = new PieData("222", 200);
        PieData c = new PieData("11311", 300);
        PieData d = new PieData("11311", 400);
        PieData e = new PieData("11111", 500);
        datas.add(a);
        datas.add(b);
        datas.add(c);
        datas.add(d);
        datas.add(e);
        pv.setData(datas);

//        insertToTongXun(getDataList());

    }


    private List<String> getDataList() {
        // 1.获得ContentResolver
        ContentResolver resolver = getContentResolver();
        // 2.利用ContentResolver的query方法查询通话记录数据库
        /**
         * @param uri 需要查询的URI，（这个URI是ContentProvider提供的）
         * @param projection 需要查询的字段
         * @param selection sql语句where之后的语句
         * @param selectionArgs ?占位符代表的数据
         * @param sortOrder 排序方式
         *
         */
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {

            return new ArrayList<>();
        }
        Cursor cursor = resolver.query(CallLog.Calls.CONTENT_URI,
                new String[]{CallLog.Calls.CACHED_NAME
                        , CallLog.Calls.NUMBER
                        , CallLog.Calls.DATE
                        , CallLog.Calls.DURATION
                        , CallLog.Calls.TYPE} // 通话类型
                , null, null, CallLog.Calls.DEFAULT_SORT_ORDER // 按照时间逆序排列，最近打的最先显示
        );

        // 3.通过Cursor获得数据
        List<String> list = new ArrayList<String>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
            String number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
            long dateLong = cursor.getLong(cursor.getColumnIndex(CallLog.Calls.DATE));
            String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date(dateLong));
            int duration = cursor.getInt(cursor.getColumnIndex(CallLog.Calls.DURATION));
            int type = cursor.getInt(cursor.getColumnIndex(CallLog.Calls.TYPE));
            String typeString = "";
            switch (type) {
                case CallLog.Calls.INCOMING_TYPE:
                    typeString = "打入";
                    break;
                case CallLog.Calls.OUTGOING_TYPE:
                    typeString = "打出";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    typeString = "未接";
                    break;
                default:
                    break;
            }
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("name", (name == null) ? "未备注联系人" : name);
//            map.put("number", number);
//            map.put("date", date);
//            map.put("duration", (duration / 60) + "分钟");
//            map.put("type", typeString);
            list.add(number);
        }
        return list;
    }


public  void insertToTongXun(List<String> list){
    ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>();
    for (String photoNumber : list) {
        ContentProviderOperation op2 = ContentProviderOperation
                .newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.Data.DATA1, photoNumber).build();// 得到了一个添加内容的对象
        operations.add(op2);
    }
    try {
        getContentResolver().applyBatch("com.android.contacts",
                operations);// 执行批量操作
    } catch (RemoteException e) {
        e.printStackTrace();
    } catch (OperationApplicationException e) {
        e.printStackTrace();
    }
}



}
