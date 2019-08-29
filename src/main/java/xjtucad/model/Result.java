package xjtucad.model;

/**
 * 实体类
 * 封装request请求结果，state是请求的状态，content是要返回的内容
 */
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
