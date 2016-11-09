package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:46.0) Gecko/20100101 Firefox/46.00";
    private static final String referrer = "http://www.google.com";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        try {

            int pageNumber = 0;
            Document doc;
            while (true) {
                doc = getDocument(searchString, pageNumber++);
                //System.out.println(doc);
                if (doc == null) break;

                Elements elements = doc.getElementsByClass("job");

                if (elements.size() == 0) break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    String city = element.getElementsByAttributeValue("class", "location").text();
                    if ((!city.equals("Киев")) && (!city.equals("")) && (!city.equals("Kiev"))) continue;
                    vacancy.setUrl( element.getElementsByClass("title").first().child(0).attr("abs:href") );
                    vacancy.setTitle( element.getElementsByAttributeValue("class", "title").text() );
                    vacancy.setCity( element.getElementsByAttributeValue("class", "location").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "salary").text());
                    vacancy.setSiteName(doc.title());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").first().getElementsByTag("a").text());
                    vacancies.add(vacancy);
                }
            }
        }
        catch (Exception e) {
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
    }
}
