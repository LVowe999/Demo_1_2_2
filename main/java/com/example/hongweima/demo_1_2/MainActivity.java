package com.example.hongweima.demo_1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button kaishi, xiayiti;
    TextView shuru, defen, diyilunfenshu, dierlunfenshu, disanlunfenshu, disilunfenshu, diwulunfenshu;
    EditText shurudaan;
    static int n, a, b, c, d, sum, temp, answer, fenshu = 0, i = 0, j = -1,insum;
    static String opr,inopr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xiayiti = (Button) findViewById(R.id.daan);
        shurudaan = (EditText) findViewById(R.id.answer);
        defen = (TextView) findViewById(R.id.defen);
        diyilunfenshu = (TextView) findViewById(R.id.diyilunfenshu);
        dierlunfenshu = (TextView) findViewById(R.id.dierlunfenshu);
        disanlunfenshu = (TextView) findViewById(R.id.disanlunfenshu);
        disilunfenshu = (TextView) findViewById(R.id.disilunfenshu);
        diwulunfenshu = (TextView) findViewById(R.id.diwulunfenshu);
        kaishi = (Button) findViewById(R.id.start);
        shuru = (TextView) findViewById(R.id.shuru);
    }
    public static void input(){
        output();
        inopr=opr+"=";
        insum=sum;

    }
    public static void output() {
        //新产生的数字总是记为a;
        //确定第一个数字
        a = 1 + (int) (Math.random() * 100);
        temp = 1 + (int) (Math.random() * 4);
        switch (temp) {
            //第一个符号为+号
            case 1:
                add();
                //确定第一个符号为-
            case 2:
                sub();
                break;
            case 3:
                rid();
                break;
            case 4:
                div();
                break;
        }
    }

    public static void add() {
        b = a;
        //确定第二个数字
        a = 1 + (int) (Math.random() * 100);
        temp = 1 + (int) (Math.random() * 4);

        switch (temp) {
            //确定第二个符号为+
            case 1:

                c = a;
                //确定第三个数字
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 4);
                d = a;
                //确定第四个数字
                a = 2 + (int) (Math.random() * 100);
                switch (temp) {

//				//第三个符号为+号
//				case 1:
//					sum=a+b+c+d;
//					opr=a+"+"+b+"+"+c+"+"+d;
//					break;
//				//第三个符号为-号
                    case 2:
                        while (b + c + d < a)
                            a = 1 + (int) (Math.random() * 100);
                        sum = b + c + d - a;
                        opr = b + "+" + c + "+" + d + "-" + a;
                        break;
                    //第三个符号为*
                    case 3:
                        sum = b + c + d * a;
                        opr = b + "+" + c + "+" + d + "*" + a;
                        break;
                    //第三个符号为/
                    case 4:
                        while (d < a || d % a != 0) {
                            d = 1 + (int) (Math.random() * 100);
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c + d / a;
                        opr = b + "+" + c + "+" + d + "/" + a;
                        break;
                }
                //确定第二个符号为-
            case 2:
                while (b + c < d) {
                    d = 1 + (int) (Math.random() * 100);
                }
                switch (temp) {
                    //确定第三个符号为+
                    case 1:
                        sum = a + b - c + d;
                        opr = b + "+" + c + "-" + d + "+" + a;
                        break;
                    //第三个符号为-
                    case 2:
                        while (b + c - d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c - d - a;
                        opr = b + "+" + c + "-" + d + "-" + a;
                        break;
                    //确定第三个符号为*
                    case 3:
                        while (b + c < d * a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c - d * a;
                        opr = b + "+" + c + "-" + d + "*" + a;
                        break;
                    //确定第三个符号为/
                    case 4:
                        while (d < a && d % a != 0) {
                            d = 1 + (int) (Math.random() * 100);
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c - d / a;
                        opr = b + "+" + c + "-" + d + "/" + a;
                        break;
                }
                break;
            //确定第二个符号为*
            case 3:
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    //确定第三个符号为+
                    case 1:
                        sum = b + c * d + a;
                        opr = b + "+" + c + "*" + d + "+" + a;
                        break;
                    //确定第三个符号为-
                    case 2:
                        while (b + c * d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c * d - a;
                        opr = b + "+" + c + "*" + d + "-" + a;
                        break;
                    case 3:
                        sum = b + c * d * a;
                        opr = b + "+" + c + "*" + d + "*" + a;
                        break;
                    case 4:
                        while (c * d < a && c * d % a != 0) {
                            d = 1 + (int) (Math.random() * 100);
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c * d / a;
                        opr = b + "+" + c + "*" + d + "/" + a;
                        break;
                }
                break;
            //确定第二个运算符为/
            case 4:
                while (c % d != 0) {
                    c = 1 + (int) (Math.random() * 100);
                }
                switch (temp) {
                    case 1:
                        sum = b + c / d + a;
                        opr = b + "+" + c + "/" + d + "+" + a;
                        break;
                    case 2:
                        while (b + c / d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c / d - a;
                        opr = b + "+" + c + "/" + d + "-" + a;
                        break;
                    case 3:
                        sum = b + c / d * a;
                        opr = b + "+" + c + "/" + d + "*" + a;
                        break;
                    case 4:
                        while (c / d % a != 0) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b + c / d / a;
                        opr = b + "+" + c + "/" + d + "/" + a;
                        break;
                }
                break;
        }
    }

    public static void sub() {
        b = a;
        c = 1 + (int) (Math.random() * 100);
        while (b < c) {
            c = 1 + (int) (Math.random() * 100);
        }
        temp = 1 + (int) (Math.random() * 2);

        d = 1 + (int) (Math.random() * 100);

        switch (temp) {
            //确定第二个符号为+
            case 1:
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    //确定第三个符号为+
                    case 1:
                        a = 1 + (int) (Math.random() * 100);
                        sum = b - c + d + a;
                        opr = b + "-" + c + "+" + d + "+" + a;
                        break;
                    case 2:
                        a = 1 + (int) (Math.random() * 100);
                        while (b - c + d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b - c + d - a;
                        opr = b + "-" + c + "+" + d + "-" + a;
                        break;
                    case 3:
                        a = 1 + (int) (Math.random() * 100);
                        sum = b - c + d * a;
                        opr = b + "-" + c + "+" + d + "*" + a;
                        break;
                    case 4:
                        a = 1 + (int) (Math.random() * 100);
                        while (d % a != 0) {
                            d = 1 + (int) (Math.random() * 100);
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b - c + d / a;
                        opr = b + "-" + c + "+" + d + "/" + a;
                        break;
                }
                break;
            //第二位符号为-
            case 2:
                while (b - c < d) {
                    d = 1 + (int) (Math.random() * 100);
                }
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    case 1:
                        a = 1 + (int) (Math.random() * 100);
                        while (b - c < d) {
                            d = 1 + (int) (Math.random() * 100);
                        }
                        sum = b - c - d + a;
                        opr = b + "-" + c + "-" + d + "+" + a;
                        break;
                    //用乘法消除重复
                    case 2:
                        a = 1 + (int) (Math.random() * 100);
                        while (b - c < d) {
                            d = 1 + (int) (Math.random() * 100);
                        }
                        sum = b - c - d + a;
                        opr = b + "-" + c + "-" + d + "+" + a;
                        break;
                    case 3:
                        a = 1 + (int) (Math.random() * 100);
                        while (b - c < d * a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b - c - d * a;
                        opr = b + "-" + c + "-" + d + "*" + a;
                        break;
                    case 4:
                        a = 1 + (int) (Math.random() * 100);
                        while (d % a != 0) {
                            while ((b - c) < d % a) {
                                d = 1 + (int) (Math.random() * 100);
                                a = 1 + (int) (Math.random() * 100);
                            }
                        }
                        sum = b - c - d / a;
                        opr = b + "-" + c + "-" + d + "/" + a;
                        break;
                }
                break;

        }
    }

    public static void rid() {
        b = a;
        c = 1 + (int) (Math.random() * 100);
        temp = 1 + (int) (Math.random() * 4);
        d = 1 + (int) (Math.random() * 100);
        switch (temp) {
            case 1:
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    case 1:
                        sum = b * c + d + a;
                        opr = b + "*" + c + "+" + d + "+" + a;
                        break;
                    case 2:
                        while (b * c + d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        opr = b + "*" + c + "+" + d + "-" + a;
                        break;
                    case 3:
                        sum = b * c + d * a;
                        opr = b + "*" + c + "+" + d + "*" + a;
                        break;
                    case 4:
                        while (d % a != 0 && d < a) {
                            d = 1 + (int) (Math.random() * 100);
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b * c + d / a;
                        opr = b + "*" + c + "+" + d + "/" + a;
                        break;
                }
                break;
            case 2:
                while (b * c < d) {
                    d = 1 + (int) (Math.random() * 100);
                }
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    case 1:
                        sum = b * c - d + a;
                        opr = b + "*" + c + "-" + d + "+" + a;
                        break;
                    case 2:
                        while (b * c - d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b * c - d - a;
                        opr = b + "*" + c + "-" + d + "-" + a;
                        break;
                    case 3:
                        while (b * c < d * a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b * c - d * a;
                        opr = b + "*" + c + "-" + d + "*" + a;
                        break;
                    case 4:
                        while (d % a != 0 && d < a) {
                            while (b * c < d % a) {
                                a = 1 + (int) (Math.random() * 100);
                                d = 1 + (int) (Math.random() * 100);
                            }
                        }
                        sum = b * c - d / a;
                        opr = b + "*" + c + "-" + d + "/" + a;
                        break;
                }
                break;
            case 3:
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 3);
                switch (temp) {
                    case 1:
                        sum = b * c * d + a;
                        opr = b + "*" + c + "*" + d + "+" + a;
                        break;
                    case 2:
                        while (b * c * d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b * c * d - a;
                        opr = b + "*" + c + "*" + d + "-" + a;
                        break;
                    case 3:
                        while (b * c * d % a != 0) {
                            a = 1 + (int) (Math.random() * 100);
                            d = 1 + (int) (Math.random() * 100);
                        }
                        sum = b * c * d / a;
                        opr = b + "*" + c + "*" + d + "/" + a;
                        break;
                }
                break;
            case 4:
                while (b * c < d && b * c % d != 0) {
                    d = 1 + (int) (Math.random() * 100);
                }
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    case 1:
                        sum = b * c / d + a;
                        opr = b + "*" + c + "/" + d + "+" + a;
                        break;
                    case 2:
                        while (b * c / d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b * c / d - a;
                        opr = b + "*" + c + "/" + d + "-" + a;
                        break;
                    case 3:
                        sum = b * c / d * a;
                        opr = b + "*" + c + "/" + d + "*" + a;
                        break;
                    case 4:
                        while (b * c / d < a && b * c / d % a != 0) {
                            c = 1 + (int) (Math.random() * 100);
                            d = 1 + (int) (Math.random() * 100);
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b * c / d / a;
                        opr = b + "*" + c + "/" + d + "/" + a;
                        break;
                }
                break;
        }
    }

    public static void div() {
        b = a;
        c = 1 + (int) (Math.random() * 100);
        while (b < c && b % c != 0) {
            b = 1 + (int) (Math.random() * 100);
            c = 1 + (int) (Math.random() * 100);
        }
        temp = 1 + (int) (Math.random() * 4);
        d = 1 + (int) (Math.random() * 100);
        switch (temp) {
            case 1:
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    case 1:
                        sum = b / c + d + a;
                        opr = b + "/" + c + "+" + d + "+" + a;
                        break;
                    case 2:
                        while (b * c + d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        opr = b + "/" + c + "+" + d + "-" + a;
                        break;
                    case 3:
                        sum = b / c + d * a;
                        opr = b + "/" + c + "+" + d + "*" + a;
                        break;
                    case 4:
                        while (d % a != 0 && d < a) {
                            d = 1 + (int) (Math.random() * 100);
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b / c + d / a;
                        opr = b + "/" + c + "+" + d + "/" + a;
                        break;
                }
                break;
            case 2:
                while (b * c < d) {
                    d = 1 + (int) (Math.random() * 100);
                }
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    case 1:
                        sum = b / c - d + a;
                        opr = b + "/" + c + "-" + d + "+" + a;
                        break;
                    case 2:
                        while (b / c - d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b / c - d - a;
                        opr = b + "/" + c + "-" + d + "-" + a;
                        break;
                    case 3:
                        while (b / c < d * a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b / c - d * a;
                        opr = b + "/" + c + "-" + d + "*" + a;
                        break;
                    case 4:
                        while (d % a != 0 && d < a) {
                            while (b / c < d % a) {
                                a = 1 + (int) (Math.random() * 100);
                                d = 1 + (int) (Math.random() * 100);
                            }
                        }
                        sum = b / c - d / a;
                        opr = b + "/" + c + "-" + d + "/" + a;
                        break;
                }
                break;
            case 3:
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 4);
                switch (temp) {
                    case 1:
                        sum = b / c * d + a;
                        opr = b + "/" + c + "*" + d + "+" + a;
                        break;
                    case 2:
                        while (b / c * d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b / c * d - a;
                        opr = b + "/" + c + "*" + d + "-" + a;
                        break;
                    case 3:
                        sum = b / c * d * a;
                        opr = b + "/" + c + "*" + d + "*" + a;
                        break;
                    case 4:
                        while (b / c * d % a != 0) {
                            a = 1 + (int) (Math.random() * 100);
                            d = 1 + (int) (Math.random() * 100);
                        }
                        sum = b / c * d / a;
                        opr = b + "/" + c + "*" + d + "/" + a;
                        break;
                }
                break;
            case 4:
                while (b / c < d && b / c % d != 0&& b%c!=0) {
                    d = 1 + (int) (Math.random() * 100);
                    b  = 1 + (int) (Math.random() * 100);
                }
                a = 1 + (int) (Math.random() * 100);
                temp = 1 + (int) (Math.random() * 3);
                switch (temp) {
                    case 1:
                        sum = b / c / d + a;
                        opr = b + "/" + c + "/" + d + "+" + a;
                        break;
                    case 2:
                        while (b / c / d < a) {
                            a = 1 + (int) (Math.random() * 100);
                        }
                        sum = b / c / d - a;
                        opr = b + "/" + c + "/" + d + "-" + a;
                        break;
                    case 3:
                        sum = b / c / d * a;
                        opr = b + "/" + c + "/" + d + "*" + a;
                        break;
                }
                break;
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.start) {
                input();
                shuru.setText(inopr);
                i=1;
                fenshu = 0;
                j++;
              if (j == 5) {
                    j = 0;
                }
            }
//                switch (j) {
//                    case 0:
//                        while (i < 20) {
//                           input();
//                            shuru.setText(inopr);
//                            i++;
//                        }
//                        diyilunfenshu.setHeight(fenshu);
//                        i = 0;
//                        break;
//                    case 1:
//                        while (i < 20) {
//                            input();
//                            shuru.setText(inopr);
//                            i++;
//                        }
//                        dierlunfenshu.setHeight(fenshu);
//                        i = 0;
//                        break;
//                    case 2:
//                        while (i < 20) {
//                            input();
//                            shuru.setText(inopr);
//                            i++;
//                        }
//                        disanlunfenshu.setHeight(fenshu);
//                        i = 0;
//                        break;
//                    case 3:
//                        while (i < 20) {
//                            input();
//                            shuru.setText(inopr);
//                            i++;
//                        }
//                        disilunfenshu.setHeight(fenshu);
//                        i = 0;
//                        break;
//                    case 4:
//                        while (i < 20) {
//                            input();
//                            shuru.setText(inopr);
//                            i++;
//                        }
//                        diwulunfenshu.setHeight(fenshu);
//                        i = 0;
//                        break;
//                }
//                fenshu = 0;
//                j++;
//                if (j == 5) {
//                    j = 0;
//        }
           else if(view.getId()== R.id.daan){
                if (Integer.valueOf(shurudaan.getText().toString()) == sum) {
                    fenshu += 5;
                    defen.setText(String.valueOf(fenshu));
                }
               if(i<20) {
                   input();
                   shuru.setText(inopr);
                   i++;
               }
            switch (j) {
                case 0:
                    diyilunfenshu.setMaxHeight(fenshu*2);
                    break;
                case 1:
                    dierlunfenshu.setMaxHeight(fenshu*2);
                    break;
                case 2:
                    disanlunfenshu.setMaxHeight(fenshu*2);
                    break;
                case 3:
                    disilunfenshu.setMaxHeight(fenshu*2);
                    break;
                case 4:
                    diwulunfenshu.setMaxHeight(fenshu*2);
                    break;
            }

               shurudaan.setText("");
           }
//
//                break;
        }
    }
//
//    public void daan(View view) {
//        daan.setText(sum);
//        if(shurudaan.getText().equals(sum)){
//            fenshu+=5;
//            defen.setText(String.valueOf(fenshu));
//        }
//
//    }
//}

