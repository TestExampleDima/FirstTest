import models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.springframework.web.client.RestTemplate;
import java.util.Collection;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstTestClass {
    @Test
    public void testUserInfoResponse(){
        String name = "Selenide";
        String sort = "desc";
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject("https://api.github.com/search/repositories?q=" + name + "&" + "order=" + sort, User.class);
        System.out.println(user);

        int intex = user.total_count;
        System.out.println(intex + " - Это GitHub API");
    }

    @Test
    public void firstTest(){
        open("https://github.com/");
        $(By.name("q")).setValue("Selenide").pressEnter();
        String selcount = $("div.d-flex.flex-justify-between.border-bottom.pb-3").find("h3").text();
        selcount = selcount.replaceAll("\\D+","");
        int selfinal = Integer.parseInt(selcount);
        System.out.println(selfinal + " - Это Selenide");
    }
    @Test
    public void secondTest(){
        open("https://github.com/");
        $(By.name("q")).setValue("Selenide").pressEnter();
        $("div.repo-list-item.d-flex.flex-justify-start.py-4.public.source").find("em").shouldHave(exactText("selenide"));
        $("p.col-9.d-inline-block.text-gray.mb-2.pr-4").shouldHave(exactText("Concise UI Tests with Java!"));
        $("div.repo-list-item.d-flex.flex-justify-start.py-4.public.source").find("div.d-table-cell.col-2.text-gray.pt-2").shouldHave(exactText("Java"));
        $("div.repo-list-item.d-flex.flex-justify-start.py-4.public.source").find("div.col-2.text-right.pt-1.pr-3.pt-2").find("a.muted-link").shouldHave(exactText("740"));
    }

}