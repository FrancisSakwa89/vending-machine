package com.franco.controllers.enums;


public class Item {
       public enum ItemsEnum {
            CANDY(10),COKE(25), PEPSI(35), SODA(45),NUTS(90),SNACKS(50);

            private String name;
            private int price;

            ItemsEnum(int price) {
//                this.name = name;
                this.price = price;
            }


            private String Item(String name, int price) {
                this.name = name;
                this.price = price;
                return name+" "+price;
            }

            public String getName() {
                return name;
            }

            public long getPrice() {
                return price;
            }


        }


    }
