import React, { useState, useEffect } from 'react';
import { Box, useTheme, Grid, Card, CardContent, CardMedia, Typography, Button } from "@mui/material";
import { tokens } from "../../../base/theme";
import Header from "../../../components/Header";
import axios from 'axios';


const ViewWebImages = () => {
    const theme = useTheme();
    const colors = tokens(theme.palette.mode);
    const [images, setImages] = useState([]);
    const [loading, setLoading] = useState(true);
    const API_BASE_URL = 'http://localhost:8082';

    useEffect(() => {
        fetchImages();
    }, []);

    const fetchImages = async () => {
        try {
            const token = localStorage.getItem('jwtToken');
            const response = await axios.get(`${API_BASE_URL}/api/webimages`, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            setImages(response.data);
            setLoading(false);
        } catch (error) {
            console.error('Error fetching images:', error);
            setLoading(false);
        }
    };

    if (loading) {
        return <Box m="20px">Loading...</Box>;
    }

    return (
        <Box m="20px">
            <Box display="flex" justifyContent="space-between" alignItems="center">
                <Header title="Website Images" subtitle="View and manage your website images" />
                <Button 
                    variant="contained" 
                    color="secondary" 
                    href="/website-image-admin"
                >
                    Add New Image
                </Button>
            </Box>
            
            <Grid container spacing={3} mt={2}>
                {images.map((image) => (
                    <Grid item xs={12} sm={6} md={4} lg={3} key={image.id}>
                        <Card sx={{ 
                            height: '100%', 
                            display: 'flex', 
                            flexDirection: 'column',
                            backgroundColor: colors.primary[400]
                        }}>
                            <CardMedia
                                component="img"
                                height="200"
                                image={`${API_BASE_URL}/api/webimages/${image.fileId}`}
                                alt={image.title}
                                sx={{ objectFit: 'cover' }}
                            />
                            <CardContent>
                                <Typography gutterBottom variant="h5" component="div">
                                    {image.title}
                                </Typography>
                                <Typography variant="body2" color="text.secondary">
                                    Place: {image.imagePlace}
                                </Typography>
                                <Typography variant="body2" color="text.secondary">
                                    Status: {image.imageStatus === '1' ? 'Published' : 'Draft'}
                                </Typography>
                                <Typography variant="body2" color="text.secondary">
                                    Tags: {image.tags}
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>
                ))}
            </Grid>
        </Box>
    );
};

export default ViewWebImages;
