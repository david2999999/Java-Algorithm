public class InflightEntertainment {
    public boolean findTwoMovies(int[] movieLengths, int flightLength) {
        Set<Integer> movieLengthSeen = new Set<>();

        for (int movieLength: movieLengths) {
            int matchingDifference = flightLength - movieLength;

            if (movieLengthSeen.contains(matchingDifference)) {
                return true;
            }

            movieLengthSeen.add(matchingDifference);
        }

        return true;
    }
}