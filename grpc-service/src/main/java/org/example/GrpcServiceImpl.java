package org.example;

import com.gprc.Author;
import com.gprc.Book;
import com.gprc.BookAuthorServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.stream.Collectors;

@GRpcService
public class GrpcServiceImpl extends BookAuthorServiceGrpc.BookAuthorServiceImplBase {
    @Override
    public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
        DummyDB.getAuthorsFromTempDb()
                .stream()
                .filter(author -> author.getAuthorId() == request.getAuthorId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getBooksByAuthor(Author request, StreamObserver<Book> responseObserver) {
//        super.getBooksByAuthor(request, responseObserver);
        System.out.println("Books By Author id");

        DummyDB.getBooksFromTempDb().stream().filter(book -> book.getAuthorId() == request.getAuthorId()).forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Book> getExpensiveBook(StreamObserver<Book> responseObserver) {
        return super.getExpensiveBook(responseObserver);
    }

    @Override
    public StreamObserver<Book> getBooksByGender(StreamObserver<Book> responseObserver) {
        return super.getBooksByGender(responseObserver);
    }
}
