import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

final class Week9Input {
    private final List<String> tokens;
    private int position;

    private Week9Input(List<String> tokens) {
        this.tokens = tokens;
    }

    static Week9Input read() throws IOException {
        String input = new String(System.in.readAllBytes(), StandardCharsets.UTF_8);
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        boolean quoted = false;
        boolean tokenStarted = false;

        for (int index = 0; index < input.length(); index++) {
            char character = input.charAt(index);
            if (character == '"') {
                quoted = !quoted;
                tokenStarted = true;
            } else if (Character.isWhitespace(character) && !quoted) {
                if (tokenStarted) {
                    tokens.add(token.toString());
                    token.setLength(0);
                    tokenStarted = false;
                }
            } else {
                token.append(character);
                tokenStarted = true;
            }
        }
        if (tokenStarted) {
            tokens.add(token.toString());
        }
        if (quoted) {
            throw new IllegalArgumentException("Input contains an unterminated quote");
        }
        return new Week9Input(tokens);
    }

    String next() {
        if (position == tokens.size()) {
            throw new IllegalArgumentException("Input ended before all fields were read");
        }
        return tokens.get(position++);
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }
}