package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.factory.ConversionFactory;
import com.atheesh.app.ws.repositories.UserRepository;
import com.atheesh.app.ws.service.UserService;
import com.atheesh.app.ws.shared.dto.UserDTO;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void init() {
    }

    @Override
    public UserDTO getUserById(Integer id) {
        Optional<UserEntity> recUserOp = userRepository.findById(id);

        if (recUserOp.isPresent()) {
            return convertEntityToDTO(recUserOp.get());
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> returnValue = new ArrayList();
        List<UserEntity> foundRecords = Lists.newArrayList(userRepository.findAll());

        for (UserEntity userEntity : foundRecords) {
            returnValue.add(convertEntityToDTO(userEntity));
        }

        return returnValue;
    }

    @Override
    public List<UserDTO> getUsersByStatus(UserStatus status) {
        List<UserEntity> userEntities = userRepository.getUserEntitiesByStatusEquals(status);
        List<UserDTO> userDTOList = new ArrayList<>();

        for(UserEntity userEntity : userEntities){
            userDTOList.add(convertEntityToDTO(userEntity));
        }

        return userDTOList;
    }

    @Override
    public UserDTO save(UserDTO newUser) {
        Date nowDate = new Date();
        newUser.setCreatedDate(nowDate);

        UserEntity userEntity = (UserEntity) ConversionFactory.conversion(newUser, new UserEntity());
        UserEntity savedUser = userRepository.save(userEntity);
        return convertEntityToDTO(savedUser);
    }

    @Override
    public boolean update(Integer id, UserDTO newUserDTO) {

        int updatedRows = userRepository.updateTheRoleById(id, newUserDTO.getFirstName(), newUserDTO.getLastName(), newUserDTO.getEmail(), newUserDTO.getPhoneNumber(),
                newUserDTO.getNic(), newUserDTO.getStatus());

        if (updatedRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public String test() {
        return "test work";
    }

    private UserDTO convertEntityToDTO(UserEntity userEntity){
        return (UserDTO) ConversionFactory.conversion(userEntity,new UserDTO());
    }


}
