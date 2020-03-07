public class URLShortener {
    public Response shortLink(Request request) {
        if (request.method() != HttpMethod.POST) {
            return new Reponse(HttpStatus.ERROR501);
        }

        String destination = request.getData().getDestination();
        String slug = request.getData().getSlug();

        if (slug == null) {
            slug = generateRandomSlug();
        }

        DB.insertLink(slug, destination);

        String responseBody = String.format("{'slug' : '%s'}", slug);
        return new Response(HttpStatus.OK200, responseBody);
    }
}