import React, { useEffect, useState } from "react";
import axios from "axios";
import { Grid, Box } from "@mui/material"; // Import MUI Grid and Box components

axios.defaults.withCredentials = true;

const API_BASE_URL = "http://localhost:8082";

export const Services = () => {
  const token = localStorage.getItem("jwtToken");
  const [products, setProducts] = useState([]);

  useEffect(() => {
    // Fetch all products from the API
    fetch(`${API_BASE_URL}/api/products/drinks`, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    })
      .then((response) => response.json())
      .then((data) => {
        setProducts(data);
        console.log("Fetched data:", data); // Check if data is correct
      })
      .catch((error) => console.error("Error fetching products:", error));
  }, [token]);

  if (products.length === 0) {
    return <div>Loading...</div>; // Loading state if products are empty
  }

  return (
    <div id="services" className="text-center">
      <div className="container">
        <div className="section-title">
          <h2>Our Services</h2>
        </div>
        <Grid container spacing={4}>
          {/* Loop through the fetched products */}
          {products.slice(0, 6).map((product, index) => (
            <Grid item xs={12} sm={6} md={4} key={product.id}>
              <Box className="service-desc" sx={{ textAlign: "center" }}>
                {/* Display image if available */}
                {product.productImage && (
                  <img
                    src={`data:image/jpeg;base64,${product.productImage}`}
                    alt={product.productTitle}
                    className="img-fluid"
                    style={{
                      width: "150px",
                      height: "150px",
                      marginBottom: "20px",
                    }}
                  />
                )}
                <h3>{product.productTitle}</h3>
                <h4>{product.productTags}</h4>
                <p>{product.productDesc}</p>
                <a href={`payment/${product.productSlug}`}>
                  <button className="btn btn-custom">Buy Now</button>
                </a>
              </Box>
            </Grid>
          ))}
        </Grid>
      </div>
    </div>
  );
};
