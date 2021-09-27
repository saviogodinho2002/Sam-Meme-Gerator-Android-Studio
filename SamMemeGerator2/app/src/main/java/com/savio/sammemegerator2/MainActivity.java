package com.savio.sammemegerator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<CheckBox> lista_check_boxes_1;
    public List<CheckBox> lista_check_boxes_2;
    public List<CheckBox> lista_check_boxes_3;
    public List<CheckBox> lista_check_boxes_4;

    public String text_parte1,text_parte2,text_parte3;

    public String textToMeme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_parte1 =  "eis que";
        text_parte2 =  "";
        text_parte3 =  "a sua namorada não tem pinto";

        textToMeme =  null;

        lista_check_boxes_1 = new ArrayList<>();
        lista_check_boxes_2 = new ArrayList<>();
        lista_check_boxes_3 =  new ArrayList<>();
        lista_check_boxes_4 = new ArrayList<>();

        lista_check_boxes_1.add(findViewById(R.id.checkBoxEisQue));
        lista_check_boxes_1.add(findViewById(R.id.checkBoxQuando));
        lista_check_boxes_1.add(findViewById(R.id.checkBoxVoce));

        lista_check_boxes_2.add(findViewById(R.id.checkBoxDez));
        lista_check_boxes_2.add(findViewById(R.id.checkBoxAmigo));
        lista_check_boxes_2.add(findViewById(R.id.checkBoxIrineu));

        lista_check_boxes_3.add(findViewById(R.id.checkBoxImgVinDiesel));
        lista_check_boxes_3.add(findViewById(R.id.checkBoxImgDez));

        lista_check_boxes_4.add((findViewById(R.id.checkBoxImgLogoPreto)));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoFoda));

    }

    public void checkedBoxClick_1(View check)  {
        //ImageView imagem = findViewById(R.id.checkBox1);
        TextView texto = findViewById(R.id.textView1);
        CheckBox cheque = findViewById(check.getId());
        if(cheque.isChecked())
            text_parte1 = cheque.getText().toString();
        else
            text_parte1 = "";
        for (CheckBox check_checagem : lista_check_boxes_1) {
            if (check_checagem != cheque) check_checagem.setChecked(false);
        }
        montarMeme();
    }
        public void checkedBoxClick_2(View check)  {
            //ImageView imagem = findViewById(R.id.checkBox1);
            TextView texto = findViewById(R.id.textView1);
            CheckBox cheque = findViewById(check.getId());
            if(cheque.isChecked())
                text_parte2 =  cheque.getText().toString();
            else
                text_parte2 = "";
            for (CheckBox check_checagem : lista_check_boxes_2) {
                if (check_checagem != cheque) check_checagem.setChecked(false);
            }
            montarMeme();
        }
    public void checkedBoxImgToMemeClick(View check) {

        CheckBox cheque = findViewById(check.getId());
        ImageView img_to_meme;
        if(cheque.isChecked()){
            if(cheque == findViewById(R.id.checkBoxImgVinDiesel)) {
                img_to_meme = findViewById(R.id.imgVinDiesel);
            }else if (cheque ==  findViewById(R.id.checkBoxImgDez)){
                img_to_meme =  findViewById(R.id.imgDez);
            }else {
                img_to_meme =  findViewById(R.id.imgBarraBranca);

            }
            ImageView img_from_meme =  findViewById(R.id.imgMeme);
            img_from_meme.setImageDrawable(img_to_meme.getDrawable());


        } else {

        }

        for (CheckBox check_checagem : lista_check_boxes_3) {
            if (check_checagem != cheque) check_checagem.setChecked(false);
        }

    }
    public void checkedBoxClick_4(View check) {

        CheckBox cheque = findViewById(check.getId());
        ImageView img_to_meme;
        ImageView img_from_meme =  findViewById(R.id.imgLogoSam);
        if(cheque.isChecked()){
            if(cheque == findViewById(R.id.checkBoxImgLogoFoda)) {
                img_to_meme = findViewById(R.id.imgLogoFoda);
            }else if (cheque ==  findViewById(R.id.checkBoxImgLogoPreto)){
                img_to_meme =  findViewById(R.id.imgLogoPreta);
            }else {
                img_to_meme =  findViewById(R.id.imgBarraBranca);

            }

            img_from_meme.setImageDrawable(img_to_meme.getDrawable());

        } else {
            img_from_meme.setImageDrawable(null);

        }

        for (CheckBox check_checagem : lista_check_boxes_4) {
            if (check_checagem != cheque) check_checagem.setChecked(false);
        }

    }

        public void montarMeme(){
            TextView texto = findViewById(R.id.textView1);
            texto.setText(text_parte1 + text_parte2+" " + text_parte3);

        }
       public void isTyping(View vasco){
           EditText caixaTxt = findViewById(R.id.cxTexto);
           text_parte3 = caixaTxt.getText().toString();
           montarMeme();


       }




}