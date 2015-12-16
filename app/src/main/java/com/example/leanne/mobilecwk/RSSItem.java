package com.example.leanne.mobilecwk;

/**
 * Created by leanne on 12/12/2015.
 */
public class RSSItem {



        // item title
        private String title;
        // item link
        private String description;

    //declare getters and setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {

            this.title = title;
        }

        public String getDescription() {

            return description;
        }

        public void setDescription(String description) {

            this.description = description;
        }

        //return information to be displayed in feed
        @Override
        public String toString() {
            return title + " : " +
                    description;

        }



    }

