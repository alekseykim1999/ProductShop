public enum StateOfCashBox {
        WORK("IS WORKING"),
        NOT_WORK("NOT WORKING");

        private String description;
        private StateOfCashBox(String s) {
            description=s;
        }
        public String getDescription()
        {
            return description;
        }
}

