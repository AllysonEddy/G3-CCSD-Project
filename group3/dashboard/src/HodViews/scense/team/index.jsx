import { Box, Typography, useTheme, Button, Grid } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";
import { Link } from "react-router-dom";
import { tokens } from "../../../base/theme";
import AdminPanelSettingsOutlinedIcon from "@mui/icons-material/AdminPanelSettingsOutlined";
import LockOpenOutlinedIcon from "@mui/icons-material/LockOpenOutlined";
import SecurityOutlinedIcon from "@mui/icons-material/SecurityOutlined";
import PersonAddAltOutlinedIcon from '@mui/icons-material/PersonAddAltOutlined';
import Header from "../../../components/Header";
import React, { useState, useEffect } from "react";
import GetItemsAdmin from "../../getItemAdmin";
import DeleteOutlineOutlinedIcon from '@mui/icons-material/DeleteOutlineOutlined';
import DeleteUser from '../../deleteUser';

const TeamAdmin = () => {
    const [teamDeatails, setTeamDetails] = useState([]);

    useEffect(() => {
        GetItemsAdmin.getTeamDataAdmin()
            .then((result) => {
                console.log('Raw data from server:', result);
                if (!result || result.length === 0) {
                    console.log('No data received from server');
                    return;
                }
                const teamData = result.map(user => {
                    console.log('Processing user:', user);
                    if (!user.firstName || !user.lastName) {
                        console.log('Missing name data for user:', user);
                    }
                    return {
                        id: user.id || 'No ID',
                        name: user.firstName && user.lastName 
                            ? `${user.firstName} ${user.lastName}`
                            : 'Name Not Available',
                        phone: user.phoneNumber || 'No Phone',
                        email: user.userEmail || 'No Email',
                        access: "Teacher",
                    };
                });
                console.log('Processed team data:', teamData);
                setTeamDetails(teamData);
            })
            .catch((error) => {
                console.error("Error fetching team data:", error);
            });
    }, []);
    
    

    const theme = useTheme();
    const colors = tokens(theme.palette.mode);
    


    const columns = [
        { field: "id", headerName: "ID" },
        { field: "name", headerName: "NAME", flex: 1, cellClassName: "name-column--cell" },
        { field: "phone", headerName: "PHONE#", flex: 1 },
        { field: "email", headerName: "EMAIL", flex: 1 },
        {
            field: "access",
            headerName: "ACCESS",
            flex: 1,
            renderCell: ({ row: { access } }) => {
                return (
                    <Box
                        width="60%"
                        m="0 auto"
                        p="5px"
                        justifyContent="center"
                        alignItems="center" // Added for vertical alignment
                        backgroundColor={
                            access === "admin"
                                ? colors.greenAccent[600]
                                : colors.greenAccent[700]
                        }
                        borderRadius="4px"
                    >
                        {access === "Teacher" && <AdminPanelSettingsOutlinedIcon />}
                        {access === "manager" && <SecurityOutlinedIcon />}
                        {access === "user" && <LockOpenOutlinedIcon />}
                        <Typography variant="body1" color={colors.grey[100]} sx={{ ml: "5px" }}>
                            {access}
                        </Typography>
                    </Box>
                );
            },
        },
        {
            field: "delete",
            headerName: "DELETE",
            flex: 1,
            renderCell: ({ row }) => {
                return (
                    <Box
                        width="40%"
                        m="0 auto"
                        p="5px"
                        display="flex"
                        justifyContent="center"
                        alignItems="center"
                        backgroundColor={colors.redAccent[600]}
                        borderRadius="4px"
                        sx={{ 
                            cursor: 'pointer',
                            '&:hover': { backgroundColor: colors.redAccent[700] }
                        }}
                        onClick={async () => {
                            if (window.confirm('Are you sure you want to delete this user?')) {
                                try {
                                    await DeleteUser.deleteUserAdmin(row.id);
                                    const updatedTeamDetails = teamDeatails.filter(user => user.id !== row.id);
                                    setTeamDetails(updatedTeamDetails);
                                    alert('User deleted successfully!');
                                } catch (error) {
                                    console.error('Failed to delete user:', error);
                                    alert(error.message);
                                }
                            }
                        }}
                    >
                        <DeleteOutlineOutlinedIcon />
                        <Typography variant="body1" color={colors.grey[100]} sx={{ ml: "5px" }}>
                            Delete
                        </Typography>
                    </Box>
                );
            },
        },
    ];
    
      

    return (
        <Box>
            <Header title="Team" subtitle="Managing the Team" />
            <Box>
                <DataGrid
                    rows={teamDeatails}
                    columns={columns}
                    pageSize={12}
                />
            </Box>
            <Link to="/AddTeam" style={{ textDecoration: 'none' }}>
                <Grid container justifyContent="flex-end">
                    <Box sx={{ m: 2, }}>
                        <Button 
                            startIcon={<PersonAddAltOutlinedIcon />}
                            justifyContent="center"
                            variant="contained"
                            size="large"
                            color = "success"
                            >Add Team Member
                        </Button>
                    </Box>
                </Grid>
            </Link>
        </Box>
    );
};

export default TeamAdmin;