package com.ray.test.testingstringbufferandstring;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView txt1, txt2, txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) this.findViewById(R.id.txt1);
        txt2 = (TextView) this.findViewById(R.id.txt2);
        txt3 = (TextView) this.findViewById(R.id.txt3);
        Button btn = (Button) this.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long start, end;
                start = System.currentTimeMillis();
                String s = "";
                for(int i=0;i<10000;i++){
                    s += i+",";
                }
                end = System.currentTimeMillis() - start;
                txt1.setText("String: "+ end +"ms");

                start = System.currentTimeMillis();
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<10000;i++){
                    sb.append(i).append(",");
                }
                end = System.currentTimeMillis() - start;
                txt2.setText("StringBuffer: "+ end +"ms");

                if(s.equals(sb.toString())){
                    txt3.setText("The content is same.");
                } else {
                    txt3.setText("The content is different.");
                }

            }
        });

    }
}
