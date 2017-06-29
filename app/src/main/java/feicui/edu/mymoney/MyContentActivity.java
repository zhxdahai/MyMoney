package feicui.edu.mymoney;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fuqianla.paysdk.FuQianLaPay;

/**
 * Created by Administrator on 2017/6/22.
 */

class MyContentActivity extends Activity{
    private EditText etname,etcontent,etmoney,ettel;
    private Button btpay;
    private String name,content,money,tel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        etname= (EditText) findViewById(R.id.etname);
        etcontent= (EditText) findViewById(R.id.etcontent);
        etmoney= (EditText) findViewById(R.id.etmoney);
        ettel= (EditText) findViewById(R.id.ettel);
        btpay= (Button) findViewById(R.id.btpay);
        btpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=etname.getText().toString();
                content=etcontent.getText().toString();
                money=etmoney.getText().toString();
                tel=ettel.getText().toString();
          //支付核心代码
        FuQianLaPay pay = new FuQianLaPay.Builder(MyContentActivity.this)
                .alipay(true)
                .wxpay(true)
                .baidupay(true)
                .unionpay(true)
                .jdpay(true)
                .fqpay(true)
                .amount(Integer.parseInt(money))//金额
                .orderID("YOUR_ORDERID")//订单号
                .subject(name)
                .body(content)
                .phone(tel)
//                .notifyUrl(Merchant.MERCHANT_NOTIFY_URL)//注意这句话必须加（只不过还没写完）
                .build();
                 pay.startPay();
            }
        });

    }
}
