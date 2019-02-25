public class TestEnumMap {
    public static void main(String[] args) {
        Map<EuCodes,Country> eu = new EnumMap<EuCodes,Country>(EuCodes.class);
        eu.put(EuCodes.AT, new Country("Austria","German",83870,8192880,40.9));
        eu.put(EuCodes.PL, new Country("Poland","Polish",312685,38536869,37.0));
        eu.put(EuCodes.FR, new Country("France","French",547030,60876136,39.1));
        System.out.println(eu.size());
        System.out.println(eu.keySet());
        System.out.println(eu.get(EuCodes.PL));
    }
}