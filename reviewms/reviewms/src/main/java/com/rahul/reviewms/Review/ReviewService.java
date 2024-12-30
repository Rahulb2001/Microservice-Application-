package com.rahul.reviewms.Review;


import java.util.Optional;

public interface ReviewService {

    Optional<Review> getallReviews(Long companyId);

    boolean addReview(Long companyId, Review review);

//    List<Review> getReviewbyCompanyId(Long companyId,Long reviewId);

    boolean updateReview(Review review, Long reviewId);

    boolean deleteReview(Long reviewId);

     Review getReviewbyId(Long reviewId);


}
