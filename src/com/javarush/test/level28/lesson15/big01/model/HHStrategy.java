package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:46.0) Gecko/20100101 Firefox/46.00";
    private static final String referrer = "https://hh.ua/search/vacancy?text=java+kiev&area=115";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 0;
            Document doc;
            while (true) {
                doc = getDocument(searchString, pageNumber++);
                if (doc == null) break;

                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    // title
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();
                    // salary
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null) { salary = salaryElement.text(); }
                    // city
                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();
                    if ((!city.equals("Киев")) && (!city.equals("Kiev")) && (!city.equals(""))) continue;
                    // company
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();
                    // site
                    String siteName = "http://hh.ua/";
                    // url
                    String url = titleElement.attr("href");
                    // add vacancy to the list

                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);
                }
            }
        }
        catch (Exception e) { }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException{

        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
        return document;
    }

}
