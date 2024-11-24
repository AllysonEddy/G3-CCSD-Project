import { Box, Grid, Card, CardContent, CardMedia, Typography, Link, useTheme } from "@mui/material";
import React from "react";
import { tokens } from "../../../base/theme";
import Header from "../../../components/Header";

const WebsiteComponentsAdmin = () => {
  const theme = useTheme();
  const colors = tokens(theme.palette.mode);

  const sections = [
    {
      href: "/website-image-admin",
      image: require("../../../assets/images/website_image.jpg"),
      title: "Website Images",
      subtitle: "You can change Website Images",
    },
    {
      href: "/website-text-admin",
      image: require("../../../assets/images/website_text.jpg"),
      title: "Website Texts",
      subtitle: "You can change Website Texts",
    },
    {
      href: "/website-image-gallery",
      image: require("../../../assets/images/website_slides.jpg"),
      title: "Website Gallery",
      subtitle: "You can change Website Gallery",
    },
  ];

  return (
    <Box m="20px">
      {/* Header Section */}
      <Box display="flex" justifyContent="space-between" alignItems="center" mb="20px">
        <Header title="WEBSITE COMPONENTS" subtitle="Choose the part you want to change" />
      </Box>

      {/* Grid Section */}
      <Grid container spacing={3}>
        {sections.map((section, index) => (
          <Grid item xs={12} sm={6} md={4} key={index}>
            <Link href={section.href} underline="none">
              <Card
                sx={{
                  backgroundColor: colors.primary[400],
                  boxShadow: 3,
                  transition: "transform 0.2s, box-shadow 0.2s",
                  "&:hover": {
                    transform: "scale(1.05)",
                    boxShadow: 6,
                  },
                }}
              >
                <CardMedia
                  component="img"
                  height="140"
                  image={section.image}
                  alt={section.title}
                />
                <CardContent>
                  <Typography variant="h6" component="div" color={colors.primary[100]} gutterBottom>
                    {section.title}
                  </Typography>
                  <Typography variant="body2" color={colors.primary[200]}>
                    {section.subtitle}
                  </Typography>
                </CardContent>
              </Card>
            </Link>
          </Grid>
        ))}
      </Grid>
    </Box>
  );
};

export default WebsiteComponentsAdmin;
