<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
	<div style="text-align: center">
	<h1>test</h1>
		<div class="container-intro">
			<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-top:1%">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class=""></li>
					<li data-target="#myCarousel" data-slide-to="1" class=""></li>
					<li data-target="#myCarousel" data-slide-to="2" class="active"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item">
						<svg class="bd-placeholder-img" width="100%" height="100%"
							xmlns="http://www.w3.org/2000/svg"
							preserveAspectRatio="xMidYMid slice" focusable="false" role="img">
                        	<rect width="100%" height="100%" fill="#777"></rect>
                    	</svg>
						<div class="container">
							<div class="carousel-caption" style="height: 80%">
								<div style="width: 100%; height: 50%">
									<img src="resources/images/test.jpg" style="height: 100%" alt="">
								</div>
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.
								</p>
								<p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
							</div>
						</div>
					</div>
					<div class="carousel-item">
						<svg class="bd-placeholder-img" width="100%" height="100%"
							xmlns="http://www.w3.org/2000/svg"
							preserveAspectRatio="xMidYMid slice" focusable="false" role="img">
                        	<rect width="100%" height="100%" fill="#777"></rect>
                    	</svg>
						<div class="container">
							<div class="carousel-caption" style="height: 80%">
								<div style="width: 100%; height: 50%">
									<img src="resources/images/test.jpg" style="height: 100%" alt="">
								</div>
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.
								</p>
								<p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
							</div>
						</div>
					</div>
					<div class="carousel-item active">
						<svg class="bd-placeholder-img" width="100%" height="100%"
							xmlns="http://www.w3.org/2000/svg"
							preserveAspectRatio="xMidYMid slice" focusable="false" role="img">
                        	<rect width="100%" height="100%" fill="#777"></rect>
                    	</svg>
						<div class="container">
							<div class="carousel-caption" style="height: 80%">
								<div style="width: 100%; height: 50%">
									<img src="resources/images/test.jpg" style="height: 100%" alt="">
								</div>
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.
								</p>
								<p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
							</div>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#myCarousel" role="button"
					data-slide="prev"> <span class="carousel-control-prev-icon"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" href="#myCarousel" role="button"
					data-slide="next"> <span class="carousel-control-next-icon"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
			</div>
			<div class="album py-5 bg-light">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="card mb-4 shadow-sm">
								<img class="bd-placeholder-img card-img-top" src="resources/images/test.jpg" style="height: 225px">
								<div class="card-body">
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.
									</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
											<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
										</div>
										<small class="text-muted">9 mins</small>
									</div>
								</div>
							</div>
						</div>
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img" aria-label="Placeholder: Thumbnail">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%"
									fill="#55595c"></rect>
								<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>
							<div class="card-body">
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
									</div>
									<small class="text-muted">9 mins</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img" aria-label="Placeholder: Thumbnail">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%"
									fill="#55595c"></rect>
								<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>
							<div class="card-body">
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
									</div>
									<small class="text-muted">9 mins</small>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img" aria-label="Placeholder: Thumbnail">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%"
									fill="#55595c"></rect>
								<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>
							<div class="card-body">
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
									</div>
									<small class="text-muted">9 mins</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img" aria-label="Placeholder: Thumbnail">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%"
									fill="#55595c"></rect>
								<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>
							<div class="card-body">
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
									</div>
									<small class="text-muted">9 mins</small>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg"
								preserveAspectRatio="xMidYMid slice" focusable="false"
								role="img" aria-label="Placeholder: Thumbnail">
                            <title>Placeholder</title>
                            <rect width="100%" height="100%"
									fill="#55595c"></rect>
								<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>
							<div class="card-body">
								<p class="card-text">This is a wider card with supporting
									text below as a natural lead-in to additional content. This
									content is a little bit longer.</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
										<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
									</div>
									<small class="text-muted">9 mins</small>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>