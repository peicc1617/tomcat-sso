package xjtucad.model;

public class Result {
        public boolean state =false;
        public String  content;

        public boolean isState() {
                return state;
        }

        public void setState(boolean state) {
                this.state = state;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }
}
