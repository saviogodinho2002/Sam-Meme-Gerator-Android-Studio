package com.savio.sammemegerator2;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.Canvas;

import android.os.Build;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
        as listas de check boxes são para desmarcar as outras quando uma for marcada em cara parametro do meme
     */
    public List<CheckBox> lista_check_boxes_1;
    public List<CheckBox> lista_check_boxes_2;
    public List<CheckBox> lista_check_boxes_3;
    public List<CheckBox> lista_check_boxes_4;

    public String text_parte1,text_parte2,text_parte3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // linha abaixo: pedir permissão pra salvar coisas no celular
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},0);
        }
        //iniciando as 3 partes do meme que aparece quando usuário entra no App
        text_parte1 =  "eis que ";
        text_parte2 =  "";
        text_parte3 =  "a sua namorada não tem pinto";


        //até o final desse metodo vai ser apenas a inicialização dos ArraysList e a adição dos componentes
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
        lista_check_boxes_3.add(findViewById(R.id.checkBoxImgPalhaco));
        lista_check_boxes_3.add(findViewById(R.id.checkBoxImgViagem));

        lista_check_boxes_4.add((findViewById(R.id.checkBoxImgLogoPreto)));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoFoda));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoSuper));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoGta));

    }
    //esse metodo é pra desmarcar as CheckBoxes dentro da lista que não são a que é passada como primeiro parametro
    public void desmarcarOutrasCheckBox(CheckBox cxTexto, List<CheckBox> caixasTexto){
        for (CheckBox checkBox: caixasTexto) {
            if(checkBox != cxTexto) checkBox.setChecked(false);
        }

    }
    //esse metodo é pra primeira lista de checkbox que são opções para a primeira parte do texto meme
    public void checkedBoxClick_1(View check)  {

        CheckBox cheque = findViewById(check.getId());
        if(cheque.isChecked())
            text_parte1 = cheque.getText().toString();
        else
            text_parte1 = "";
        desmarcarOutrasCheckBox(cheque,lista_check_boxes_1);
        montarMeme();
    }
    //esse metodo é pra segunda lista de checkbox que são opções para a segunda parte do texto meme
        public void checkedBoxClick_2(View check)  {

            CheckBox cheque = findViewById(check.getId());
            if(cheque.isChecked())
                text_parte2 =  cheque.getText().toString();
            else
                text_parte2 = "";
            desmarcarOutrasCheckBox(cheque,lista_check_boxes_2);
            montarMeme();
        }
        //esse metodo aqui é para as checkbox da escolha da img de fundo do meme
    public void checkedBoxImgToMemeClick(View check) {

        CheckBox cheque = findViewById(check.getId());
        ImageView img_to_meme;
        if(cheque.isChecked()){
            if(cheque == findViewById(R.id.checkBoxImgVinDiesel)) {

                img_to_meme = findViewById(R.id.imgVinDiesel);

            }else if (cheque ==  findViewById(R.id.checkBoxImgDez)){

                img_to_meme =  findViewById(R.id.imgDez);

            }else if(cheque == findViewById(R.id.checkBoxImgViagem)){

                img_to_meme = findViewById(R.id.imgViagem);

            }else if(cheque == findViewById(R.id.checkBoxImgPalhaco)){

                img_to_meme =  findViewById(R.id.imgPalhaco);

            }
            else {
                img_to_meme =  findViewById(R.id.imgBarraBranca);

            }
            ImageView img_from_meme =  findViewById(R.id.imgMeme);
            img_from_meme.setImageDrawable(img_to_meme.getDrawable());


        } else {

        }

        desmarcarOutrasCheckBox(cheque,lista_check_boxes_3);

    }
    //esse metodo aqui é para as checkbox da escolha da img de Logo do meme
    public void checkedBoxImgToLogoClick(View check) {

        CheckBox cheque = findViewById(check.getId());
        ImageView img_to_meme;
        ImageView img_from_meme =  findViewById(R.id.imgLogoSam);
        if(cheque.isChecked()){
            if(cheque == findViewById(R.id.checkBoxImgLogoFoda)) {

                img_to_meme = findViewById(R.id.imgLogoFoda);

            }else if (cheque ==  findViewById(R.id.checkBoxImgLogoPreto)){

                img_to_meme =  findViewById(R.id.imgLogoPreta);

            }
            else if(cheque == findViewById(R.id.checkBoxImgLogoGta)){

                img_to_meme = findViewById(R.id.imgLogoGta);

            }else if(cheque == findViewById(R.id.checkBoxImgLogoSuper)) {

                img_to_meme = findViewById(R.id.imgLogoSuper);
            }
            else {
                img_to_meme =  findViewById(R.id.imgBarraBranca);

            }

            img_from_meme.setImageDrawable(img_to_meme.getDrawable());

        } else {
            img_from_meme.setImageDrawable(null);

        }

        desmarcarOutrasCheckBox(cheque,lista_check_boxes_4);
    }
        //esse metodo é pra montar o texto engraçado humor piadas
        public void montarMeme(){
            TextView texto = findViewById(R.id.textView1);
            texto.setText(text_parte1 + text_parte2+" " + text_parte3);

        }
        //esse é pra passar o texto da EditText pro devido parametro
       public void AddTextFromEditText(View vasco){
           EditText caixaTxt = findViewById(R.id.cxTexto);
           text_parte3 = caixaTxt.getText().toString();
           montarMeme();
       }
    //esse metodo salva o meme na galeria
    public void btnSalvarImgClicked(View v){
        Bitmap meme = screenShot(findViewById(R.id.telaprint));
        MediaStore.Images.Media.insertImage(getContentResolver(), meme, "SamMemeGeratorMeme" , "meme");
        Toast.makeText(this,"salvo na galeira",Toast.LENGTH_SHORT).show();

    }
    //esse metodo captura em um bitmap o componente
    public Bitmap screenShot(View view) {
        View img = findViewById(R.id.imgMeme);
        Bitmap bitmap = Bitmap.createBitmap(img.getWidth(),
                img.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

}