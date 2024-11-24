import { Box, Button } from "@mui/material";
import Header from "../../../components/Header";
import { useNavigate } from 'react-router-dom';

const DashboardAdmin = () => {
    const navigate = useNavigate();

    return <Box m="20px">
        <Box display="flex" justifyContent="space-between" alignItems="center">
            <Header title="DASHBOARD" subtitle="Welcome to Wesitex Dashboard" />
        </Box>
        <Box mt="20px">
            <Button 
                variant="contained" 
                color="primary"
                onClick={() => navigate('/view-web-images')}
            >
                View Website Images
            </Button>
        </Box>
    </Box>
}

export default DashboardAdmin;