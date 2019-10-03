package Moderate;

public class XMLEncoding {
    private String encodeToString(Element root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(Element root, StringBuilder sb) {
        encode(root.getNameCode(), sb);
        for (Attribute attr: root.attributes) {
            encode(attr, sb);
        }

        encode("0", sb);

        if (root.value != null && !root.value.equals("")) {
            encode(root.value, sb);
        } else {
            for (Element child: root.children) {
                encode(child, sb);
            }
        }

        encode("0", sb);
    }


    private void encode(String v, StringBuilder sb) {
        sb.append(v);
        sb.append(" ");
    }

    private void encode(Attribute attribute, StringBuilder sb) {
        encode(attribute.getTagCode(), sb);
        encode(attribute.value, sb);
    }


    private class Element {
        public Attribute[] attributes;
        public String nameCode;
        public String value;
        public Element[] children;

        public String getNameCode() {
            return nameCode;
        }
    }

    private class Attribute {

        public String value;

        public String getTagCode() {
            return "Tag Code";
        }
    }
}
