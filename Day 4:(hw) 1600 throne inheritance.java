public class ThroneInheritance {

    private String king;
    private Set<String> dead;
    private Map<String, List<String>> family;

    public ThroneInheritance(String kingName) {
        king = kingName;
        dead = new HashSet<>();
        family = new HashMap<>();
    }

    public void birth(String parentName, String childName) {
        family.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String person, List<String> order) {
        if (!dead.contains(person)) {
            order.add(person);
        }

        List<String> children = family.getOrDefault(person, new ArrayList<>());

        for (String child : children) {
            dfs(child, order);
        }
    }
}

