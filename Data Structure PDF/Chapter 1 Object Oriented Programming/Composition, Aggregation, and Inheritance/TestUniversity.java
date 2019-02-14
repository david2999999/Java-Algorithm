 public class TestUniversity {
     public static void main(String[] args) {
         University jsu = new University("JavaStateUniversity");
         Professor adams = new Professor("Adams", Professor.Rank.ASSOC);
         Professor baker = new Professor("Baker", Professor.Rank.ASST);
         Professor cohen = new Professor("Cohen", Professor.Rank.PROF);
         Set<Professor> profs = new HashSet<Professor>();
         Collections.addAll(profs, adams, baker, cohen);
         jsu.addDepartment("Computer Science", profs);
         Professor davis = new Professor("Davis", Professor.Rank.ASST);
         Professor evans = new Professor("Evans", Professor.Rank.INSTR);
         profs.clear();
         Collections.addAll(profs, davis, evans, baker);
         jsu.addDepartment("Biology", profs);
         adams.setRank(Professor.Rank.PROF);
     }
 }