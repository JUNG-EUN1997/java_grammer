package C07ExceptionFileParsing.AuthorException;

import java.util.ArrayList;
import java.util.List;

class AuthorRepository {
    static List<Author> authorList;

    AuthorRepository(){
        authorList = new ArrayList<>();
    }

    void register(Author author){
        authorList.add(author);
    }
}
