package com.savio.sammemegerator2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
        as listas de check boxes são para desmarcar as outras quando uma for marcada em cara parametro do meme
     */
    private List<CheckBox> lista_check_boxes_1;
    private List<CheckBox> lista_check_boxes_2;
    private List<CheckBox> lista_check_boxes_3;
    private List<CheckBox> lista_check_boxes_4;

    private String text_parte1,text_parte2,text_parte3;

    private Uri selectedUriMeme, selectedUriLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // linha abaixo: pedir permissão pra salvar coisas no celular
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},0);
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"},1);
        }
        iniciandoListas();
        iniciandoSeekBars();



    }
    public  void iniciandoSeekBars(){
        SeekBar seekBarX = findViewById(R.id.seekBarX);
        seekBarX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mudaOrientacaoMeme(seekBar, progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBarY = findViewById(R.id.seekBarY);
        seekBarY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mudaOrientacaoMeme(seekBar, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBarZ = findViewById(R.id.seekBarZ);
        seekBarZ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mudaOrientacaoMeme(seekBar, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void iniciandoListas(){
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
        lista_check_boxes_3.add(findViewById(R.id.checkBoxImgUser));

        lista_check_boxes_4.add((findViewById(R.id.checkBoxImgLogoPreto)));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoFoda));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoSuper));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoGta));
        lista_check_boxes_4.add(findViewById(R.id.checkBoxImgLogoUser));


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

            }else  if(cheque == findViewById(R.id.checkBoxImgUser)){
                img_to_meme = findViewById(R.id.imgUser);
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

            }else if(cheque == findViewById(R.id.checkBoxImgLogoUser)){
               img_to_meme = findViewById(R.id.imgLogoUser);
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
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Bitmap meme = screenShot(findViewById(R.id.telaprint));
            MediaStore.Images.Media.insertImage(getContentResolver(), meme, "SamMemeGeratorMeme", "meme");
            Toast.makeText(this, "salvo na galeira", Toast.LENGTH_SHORT).show();
        }
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

    public void selectImgMemeClick(View view) {
       Intent intent = new Intent(Intent.ACTION_PICK);
       intent.setType("image/*");
       startActivityForResult(intent,3);
      ImageView imageView_from_gallery = findViewById(view.getId());
       imageView_from_gallery.setImageURI(selectedUriMeme);



    }
    public void selectImgLogoClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,4);

    }
    public void desmarcaCheckbox(int box_id){
        CheckBox box = findViewById(box_id);
        ImageView img_to_meme,img_from_meme;

        if((box.isChecked()) && (box == findViewById(R.id.checkBoxImgUser)) ){
            img_from_meme = findViewById(R.id.imgMeme);
         img_to_meme = findViewById(R.id.imgUser);
        }else if((box.isChecked()) && (box == findViewById(R.id.checkBoxImgLogoUser))){
            img_from_meme = findViewById(R.id.imgLogoSam);
            img_to_meme = findViewById(R.id.imgLogoUser);
        }else {
            img_to_meme =  null;
            img_from_meme = null;
        }
        if(img_from_meme != null)
        img_from_meme.setImageDrawable(img_to_meme.getDrawable());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if(requestCode == 3) {
                selectedUriMeme = data.getData();
                ImageView imageView_from_gallery = findViewById(R.id.imgUser);
                imageView_from_gallery.setImageURI(selectedUriMeme);
                desmarcaCheckbox(R.id.checkBoxImgUser);
            }else if(requestCode == 4){
                selectedUriLogo = data.getData();
                ImageView imageView_from_gallery = findViewById(R.id.imgLogoUser);
                imageView_from_gallery.setImageURI(selectedUriLogo);
                desmarcaCheckbox(R.id.checkBoxImgLogoUser);
            }
        }catch (Exception e){

        }

    }
    public void mudaOrientacaoMeme(SeekBar seekBar, int progress){
        ImageView meme = findViewById(R.id.imgMeme);

        if(seekBar == findViewById(R.id.seekBarX)) {

            meme.setRotationX(progress);

        }else if(seekBar == findViewById(R.id.seekBarY)){

            meme.setRotationY(progress);
        }else if(seekBar == findViewById(R.id.seekBarZ)){

            meme.setRotation(progress);
        }
    }

}