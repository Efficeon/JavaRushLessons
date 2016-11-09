package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View
{
    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        String content = null;
        try
        {
            Document document = getDocument();
            Element elTemplateCl = document.select(".template").first();
            Element copyTemplate = elTemplateCl.clone();

            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");

            document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : vacancies){
              Element clone = copyTemplate.clone();
                clone.getElementsByClass("city").first().text(vacancy.getCity());
                clone.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                clone.getElementsByClass("salary").first().text(vacancy.getSalary());

                Element link = clone.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                elTemplateCl.before(clone.outerHtml());

                content = document.html();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            content = "Some exception occurred";
        }

        return content;
    }

    private void updateFile(String line){
       try(FileWriter writer = new FileWriter(filePath))
       {
            writer.write(line);
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Kiev");
    }

    protected Document getDocument() throws IOException{
      return  Jsoup.parse(new File(filePath), "UTF-8");
    }
}
