package com.rahul.reviewms.Review;



import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImplementaion implements ReviewService {

    ReviewRepository reviewRepository;


    public ReviewServiceImplementaion(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;

    }

    @Override
    public Optional<Review> getallReviews(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
//        boolean companyExist = companyService.findcompany(companyId);
//        System.out.println("companyExist = " + companyExist);
        if (companyId!=null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateReview(Review review, Long reviewId) {
//        boolean companyExist = companyService.findcompany(companyId);
        Review review1 = reviewRepository.findById(reviewId).get();
        if (reviewId != null && review != null) {
            boolean reviewExist = reviewRepository.existsById(reviewId);
            if (reviewExist) {
                review1.setTitle(review.getTitle());
                review1.setRating(review.getRating());
                review1.setDescription(review.getDescription());
                review1.setCompanyId(review.getCompanyId());

//                review.setId(reviewId);
//                review.setCompany(companyService.getcompanybyid(companyId));
                reviewRepository.save(review1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {

        if (reviewId != null) {
            boolean reviewExist = reviewRepository.existsById(reviewId);
            if (reviewExist) {
                reviewRepository.deleteById(reviewId);
                return true;
            }
        }
        return false;
    }

    @Override
    public Review getReviewbyId(Long reviewId) {
        return reviewRepository.findById(reviewId).get();
    }

//    @Override
//    public List<Review> getReviewbyCompanyId(Long companyId,Long reviewId) {
//        boolean companyExist = companyService.findcompany(companyId);
//        System.out.println(companyExist);
//        if (companyExist) {
//            List<Review> reviews = reviewRepository.findByCompanyCompanyId(companyId);
//            List<Review> filterReviews;
//            if (reviews != null) {
//                filterReviews = reviews.stream().filter(review -> review.getId() == reviewId).toList();
//                return filterReviews;
//            }else{
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
}
