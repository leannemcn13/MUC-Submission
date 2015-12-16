package com.example.leanne.mobilecwk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import java.io.Serializable;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by leanne on 16/12/2015.
 */
public class LeagueInfo  extends Activity implements Serializable{



    private LeagueActivity local;
    private String Position;
    private String TeamName;
    private String Points;
    private String MatchesPlayed;
    private String MatchesWon;
    private String MatchesDrawn;
    private String MatchesLost;


    private static final long serialVersionUID= 0L;


    //Declare getters and setters

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        this.TeamName = teamName;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        this.Points = points;
    }

    public String getMatchesPlayed() {
        return MatchesPlayed;
    }

    public void setMatchesPlayed(String matchesPlayed) {
        this.MatchesPlayed = matchesPlayed;
    }

    public String getMatchesWon() {
        return MatchesWon;
    }

    public void setMatchesWon(String matchesWon) {
        this.MatchesWon = matchesWon;
    }

    public String getMatchesDrawn() {
        return MatchesDrawn;
    }

    public void setMatchesDrawn(String matchesDrawn) {
        this.MatchesDrawn = matchesDrawn;
    }

    public String getMatchesLost() {
        return MatchesLost;
    }

    public void setMatchesLost(String matchesLost) {
        this.MatchesLost = matchesLost;
    }

    @Override
    public String toString(){
        return "Position: " + Position + " Team Name: " + TeamName + " Points: " + Points;
    }

    public List<LeagueInfo> getItems() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        LeagueInfo leagueInfo = new LeagueInfo();


        return leagueInfo.getItems();

    }
}

