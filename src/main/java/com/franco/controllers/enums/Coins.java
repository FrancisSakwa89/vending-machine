package com.franco.controllers.enums;



public class Coins {
   public enum CoinEnum {
        PENNY(1), NICKLE(5), DIME(10), QUARTER(25),DOLLAR(100);

        private int denomination;

        CoinEnum(int denomination) {
            this.denomination = denomination;

        }

        public int getDenomination() {
            return denomination;
        }
    }


}
