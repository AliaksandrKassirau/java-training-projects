package com.epam.memory;

public class EnumExamples {

    public static void main(String[] args) {
        Processing processing = new Processing();
        processing.setStatus(Processing.Status.SUCCESSFUL);
        System.out.println(Processing.Status.FAILED.getTextPresentation());
    }
}

class Processing {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum  Status {
        SUCCESSFUL(true, "S"),
        FAILED(false, "F");

        private boolean status;
        private String textPresentation;

        Status(boolean status, String textPresentation) {
            this.status = status;
            this.textPresentation = textPresentation;
        }

        public boolean isStatus() {
            return status;
        }

        public String getTextPresentation() {
            return textPresentation;
        }
    }
}
