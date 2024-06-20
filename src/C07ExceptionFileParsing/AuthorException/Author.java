package C07ExceptionFileParsing.AuthorException;

class Author { //entity 라고 부른다~
    String name;
    String email;
    String password;
    AuthorService authorService;


    Author(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        authorService = new AuthorService();
        authorService.register(this);
    };

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
