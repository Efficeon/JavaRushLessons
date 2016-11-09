package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;


public class Controller
{
    private View view;

    private HTMLDocument document;
    private File currentFile;

    public Controller(View view)
    {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {
        createNewDocument();
    }

    public void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument()
    {
        return document;
    }

    public void resetDocument(){
        if (document != null)
        {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document= (HTMLDocument) htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        HTMLEditorKit kit = new HTMLEditorKit();
        try
        {
            kit.read(reader, document, 0);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter writer = new StringWriter();
        HTMLEditorKit kit = new HTMLEditorKit();

        try
        {
            kit.write(writer, document, 0, document.getLength());
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e)
        {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument(){
        view.selectHtmlTab();
        //Создавать новый объект для выбора файла JFileChooser
        JFileChooser jFileChooser = new JFileChooser();
        //Устанавливать ему в качестве фильтра объект HTMLFileFilter
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно "Save File" для выбора файла
        int n = jFileChooser.showOpenDialog(view);

        //Когда файл выбран, необходимо
        if (n == JFileChooser.APPROVE_OPTION) {
            //Установить новое значение currentFile
            currentFile = jFileChooser.getSelectedFile();
            //Сбросить документ
            resetDocument();
            //Установить имя файла в заголовок у представления
            view.setTitle(currentFile.getName());

            //Создать FileReader, используя currentFile
            try (FileReader fileReader = new FileReader(currentFile)) {
                //Вычитать данные из FileReader-а в документ document с помощью объекта класса
                new HTMLEditorKit().read(fileReader, document, 0);
                //Сбросить правки
                view.resetUndo();
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument()
    {
        if (currentFile == null)
        {
            saveDocumentAs();
        } else
        {
            view.selectHtmlTab();
            try (FileWriter fileWriter = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());

        int i = chooser.showSaveDialog(view);

        if (i == JFileChooser.APPROVE_OPTION){
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

}
