package com.rahul.reviewms.Review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    ReviewServiceImplementaion reviewServiceImplementaion;

    public ReviewController(ReviewServiceImplementaion reviewServiceImplementaion) {
        this.reviewServiceImplementaion = reviewServiceImplementaion;
    }

    @GetMapping
    public ResponseEntity<Optional<Review>> getAllReviews(@RequestParam Long companyId) {
        Optional<Review> reviews = reviewServiceImplementaion.getallReviews(companyId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(reviews, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {

        boolean result = reviewServiceImplementaion.addReview(companyId, review);
        if (!result) {
            return new ResponseEntity<>("Company doesn't exist So cannot add the review", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewbyId(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewServiceImplementaion.getReviewbyId(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview( @PathVariable Long reviewId, @RequestBody Review review) {

        boolean result = reviewServiceImplementaion.updateReview(review, reviewId);
        if (!result) {
            return new ResponseEntity<>("Company doesn't exist so cannot update", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Review updated successfully", HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {

        boolean result = reviewServiceImplementaion.deleteReview(reviewId);
        if (!result) {
            return new ResponseEntity<>("Company doesn't exist so cannot delete", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.CREATED);
        }

    }

//    @GetMapping("/reviews/{reviewId}")
//    public ResponseEntity<List> getReviewbyCompanyId(@PathVariable Long companyId,
//                                                     @PathVariable Long reviewId) {
//        System.out.println(companyId);
//        System.out.println(reviewId);
//        List<Review> reviews = reviewServiceImplementaion.getReviewbyCompanyId(companyId, reviewId);
//        if (reviews.isEmpty()) {
//            return new ResponseEntity<>(reviews, HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(reviews, HttpStatus.OK);
//        }
//    }

}
