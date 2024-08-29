package com.allaboutsports.AaS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String showCategoryPage() {
        return "category";
    }

    // 카테고리페이지에서 접속가능한 페이지 [축구, 골프, 헬스, 필라테스, 다이어트]
    @RequestMapping(value = "/soccer", method = RequestMethod.GET)
    public String showSoccerPage() {
        return "soccer";
    }

    @RequestMapping(value = "/golf", method = RequestMethod.GET)
    public String showGolfPage() {
        return "golf";
    }

    @RequestMapping(value = "/workout", method = RequestMethod.GET)
    public String showWorkOutPage() {
        return "workout";
    }

    @RequestMapping(value = "/pilates", method = RequestMethod.GET)
    public String showPilatesPage() {
        return "pilates";
    }

    @RequestMapping(value = "/diet", method = RequestMethod.GET)
    public String showDietPage() {
        return "diet";
    }

    //축구 카테고리에서 접속가능한 페이지 [축구필드, 크루, 매칭, 커뮤니티]
    @RequestMapping(value = "/soccer_field", method = RequestMethod.GET)
    public String showSoccerFieldPage() {
        return "soccer_field";
    }
    @RequestMapping(value = "/soccer_matching", method = RequestMethod.GET)
    public String showSoccerMatchingPage() {
        return "soccer_matching";
    }
    @RequestMapping(value = "/soccer_crew", method = RequestMethod.GET)
    public String showSoccerCrewPage() {
        return "soccer_crew";
    }


    //골프 카테고리에서 접속가능한 페이지 [골프 CC, 골프 센터, 매칭, 커뮤니티]
    @RequestMapping(value = "/golf_cc", method = RequestMethod.GET)
    public String showGolfCCPage() {
        return "golf_cc";
    }
    @RequestMapping(value = "/golf_center", method = RequestMethod.GET)
    public String showGolfCenterPage() {
        return "golf_center";
    }
    @RequestMapping(value = "/golf_matching", method = RequestMethod.GET)
    public String showGolfMatchingPage() {
        return "golf_matching";
    }

    //헬스 카테고리에서 접속가능한 페이지 [헬스장, 크루, 매칭, 커뮤니티]
    @RequestMapping(value = "/workout_center", method = RequestMethod.GET)
    public String showWorkOutCenterPage() {
        return "workout_center";
    }
    @RequestMapping(value = "/workout_crew", method = RequestMethod.GET)
    public String showWorkOutCrewPage() {
        return "workout_crew";
    }
    @RequestMapping(value = "/workout_matching", method = RequestMethod.GET)
    public String showWorkOutMatchingPage() {
        return "workout_matching";
    }

    //필라테스 카테고리에서 접속가능한 페이지 [필라테스 센터, 커뮤니티]
    @RequestMapping(value = "/pilates_center", method = RequestMethod.GET)
    public String showPilatesCenterPage() {
        return "pilates_center";
    }

    //다이어트 카테고리에서 접속가능한 페이지 [클라이밍, 등산, 런닝, 커뮤니티]
    @RequestMapping(value = "/diet_runningCrew", method = RequestMethod.GET)
    public String showDietRunningCrewPage() {
        return "diet_runningCrew";
    }

    @RequestMapping(value = "/diet_hikingCrew", method = RequestMethod.GET)
    public String showDietHikingCrewPage() {
        return "diet_hikingCrew";
    }

    @RequestMapping(value = "/diet_climbingCrew", method = RequestMethod.GET)
    public String showDietClimbingCrewPage() {
        return "diet_climbingCrew";
    }

    //커뮤니티 페이지 접속
    @RequestMapping(value = "/community", method = RequestMethod.GET)
    public String showCommunityPage() {
        return "community";
    }

}
