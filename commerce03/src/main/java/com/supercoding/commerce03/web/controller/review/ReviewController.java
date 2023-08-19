package com.supercoding.commerce03.web.controller.review;

import com.supercoding.commerce03.service.review.ReviewService;
import com.supercoding.commerce03.web.dto.review.CreateReview;
import com.supercoding.commerce03.web.dto.review.DeleteReview;
import com.supercoding.commerce03.web.dto.review.GetReview;
import com.supercoding.commerce03.web.dto.review.ModifyReview;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/api/reviews")
@RestController
public class ReviewController {

	private final ReviewService reviewService;

	@PostMapping
	public ResponseEntity<CreateReview.Response> createReview(
			@RequestBody CreateReview.Request request
	){
			Long userId = 1L;
			return ResponseEntity.ok(
					CreateReview.Response.from(
							reviewService.createReview(request, userId)
					)
			);
	}

	@PutMapping
	public ResponseEntity<ModifyReview.Response> modifyReview(
			@RequestBody ModifyReview.Request request
	){
			Long userId = 1L;
			return ResponseEntity.ok(
					ModifyReview.Response.from(
							reviewService.modifyReview(request, userId)
					)
			);
	}

	@DeleteMapping("/{reviewId}")
	public ResponseEntity<DeleteReview.Response> deleteReview(
			@PathVariable("reviewId") Long reviewId
	){
			Long userId = 1L;
			return ResponseEntity.ok(
					DeleteReview.Response.from(
							reviewService.deleteReview(reviewId, userId)
					)
			);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Page<GetReview.Response>> getReview(
			@PathVariable("productId") Long productId,
			@RequestParam(defaultValue = "0") Long cursor,
			@RequestParam(defaultValue = "10") Integer pageSize
	){
			return ResponseEntity.ok(
					reviewService.getReview(productId, cursor, pageSize).map(GetReview.Response::from)
			);
	}
}
