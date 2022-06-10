#include "CgSceneGraph.h"

CgSceneGraph::CgSceneGraph()
{
    // create all objs
    obj_man     = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Man_sitting.obj"));
    obj_king    = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("King.obj"));
    obj_queen   = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Queen.obj"));
    obj_bishop  = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Bishop.obj"));
    obj_knight  = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Knight.obj"));
    obj_rook    = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Rook.obj"));

    obj_cube = new CgUnityCube(Functions::getId());

    std::vector<glm::vec3> indices;
    indices.push_back(glm::vec3(0.0,0.0,0.0));
    indices.push_back(glm::vec3(5.0,0.0,0.0));
    indices.push_back(glm::vec3(4.0,2.0,0.0));
    indices.push_back(glm::vec3(2.0,4.0,0.0));
    indices.push_back(glm::vec3(3.0,5.0,0.0));
    indices.push_back(glm::vec3(1.0,10.0,0.0)); //-
    indices.push_back(glm::vec3(3.0,10.5,0.0));
    indices.push_back(glm::vec3(1.0,11.0,0.0)); //-
    indices.push_back(glm::vec3(1.5,11.5,0.0));
    indices.push_back(glm::vec3(2.5,12.0,0.0));
    indices.push_back(glm::vec3(2.7,12.5,0.0));
    indices.push_back(glm::vec3(3.0,13.0,0.0));
    indices.push_back(glm::vec3(2.7,13.5,0.0));
    indices.push_back(glm::vec3(2.5,14.0,0.0));
    indices.push_back(glm::vec3(1.5,14.3,0.0));
    indices.push_back(glm::vec3(1.0,14.6,0.0));
    indices.push_back(glm::vec3(0.0,14.8,0.0));
    obj_pawn = new CgRotation(Functions::getId(),indices,indices.size(),30);

    m_index_of_selected_gui_elem = -1;

    // init all lists of objects which gets passed to the constructur of the entities
    o_all_objects.push_back(obj_cube);
    o_all_objects.push_back(obj_pawn);
    o_all_objects.push_back(obj_man);
    o_all_objects.push_back(obj_king);
    o_all_objects.push_back(obj_queen);
    o_all_objects.push_back(obj_bishop);
    o_all_objects.push_back(obj_knight);
    o_all_objects.push_back(obj_rook);

    // Initialize World
    m_world = new CgSceneGraphEntity(obj_cube);
    m_world->setAppearance(new CgAppearance());
    m_world->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_world->setObjectTransformation(glm::scale(m_world->getObjectTransformation(),
                                                glm::vec3(0.01, 0.01, 0.01)));
    m_modelview_matrix_stack.push(m_world->getCurrentTransformation());

    // Initialize Stuhl

    m_stuhlbein_ul = new CgSceneGraphEntity(obj_cube);
    m_stuhlbein_ul->setCurrentTransformation(glm::mat4(glm::vec4(0.66342, 0, 0, 0),
                                                  glm::vec4(0, 2.88165, 0, 0),
                                                  glm::vec4(0, 0, 0.66342, 0),
                                                  glm::vec4(-4.8, -3.7, 0.85, 1)));
    m_stuhlbein_ul->setAppearance(new CgAppearance());
    m_stuhlbein_ul->getAppearance().setObjectColor(Functions::getWhite());
    m_stuhlbein_ul->setParent(m_world);

    m_stuhlbein_ur = new CgSceneGraphEntity(obj_cube);
    m_stuhlbein_ur->setAppearance(new CgAppearance());
    m_stuhlbein_ur->setObjectTransformation(glm::mat4(glm::vec4(1.0, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 1.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 1.0, 0.0),
                                                  glm::vec4(2.5, 0.0, 0.0, 1.0)));
    m_stuhlbein_ur->getAppearance().setObjectColor(Functions::getWhite());
    m_stuhlbein_ul->pushChildren(m_stuhlbein_ur);

    m_stuhlbein_ol = new CgSceneGraphEntity(obj_cube);
    m_stuhlbein_ol->setAppearance(new CgAppearance());
    m_stuhlbein_ol->setObjectTransformation(glm::mat4(glm::vec4(1.0, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 1.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 1.0, 0.0),
                                                  glm::vec4(0.0, 0.0, -3.0, 1.0)));
    m_stuhlbein_ol->getAppearance().setObjectColor(Functions::getWhite());
    m_stuhlbein_ul->pushChildren(m_stuhlbein_ol);

    m_stuhlbein_or = new CgSceneGraphEntity(obj_cube);
    m_stuhlbein_or->setAppearance(new CgAppearance());
    m_stuhlbein_or->setObjectTransformation(glm::mat4(glm::vec4(1.0, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 1.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 1.0, 0.0),
                                                  glm::vec4(2.5, 0.0, -3.0, 1.0)));
    m_stuhlbein_or->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_stuhlbein_ul->pushChildren(m_stuhlbein_or);

    m_stuhlplate = new CgSceneGraphEntity(obj_cube);
    m_stuhlplate->setAppearance(new CgAppearance());
    m_stuhlplate->setObjectTransformation(glm::mat4(glm::vec4(3.40753, 0, 0, 0),
                                                  glm::vec4(0, 0.0694426, 0, 0),
                                                  glm::vec4(0, 0, 3.97438, 0),
                                                  glm::vec4(1.25, 0.55, -1.5, 1)));
    m_stuhlplate->getAppearance().setObjectColor(Functions::getWhite());
    m_stuhlbein_ul->pushChildren(m_stuhlplate);

    m_lehne = new CgSceneGraphEntity(obj_cube);
    m_lehne->setAppearance(new CgAppearance());
    m_lehne->setObjectTransformation(glm::mat4(glm::vec4(0.397214, 0, 0, 0),
                                             glm::vec4(0, 1.52438, 0, 0),
                                             glm::vec4(0, 0, 3.86169, 0),
                                             glm::vec4(-0.25, 1.3, -1.45, 1)));
    m_lehne->getAppearance().setObjectColor(Functions::getWhite());
    m_stuhlbein_ul->pushChildren(m_lehne);

    // initiliaze man
    m_man = new CgSceneGraphEntity(obj_man);
    m_man->setAppearance(new CgAppearance());
    m_man->setObjectTransformation(glm::mat4(glm::vec4(-0.0349137, 0, -0.265196, 0),
                                             glm::vec4(0, 0.0659707, 0, 0),
                                             glm::vec4(0.165278, 0, -0.0217593, 0),
                                             glm::vec4(3.85, -0.6, -1.55, 1)));
    m_man->getAppearance().setObjectColor(Functions::getWhite());
    m_stuhlbein_ul->pushChildren(m_man);

    //Table
    m_tischplatte = new CgSceneGraphEntity(obj_cube);
    m_tischplatte->setAppearance(new CgAppearance());
    m_tischplatte->setObjectTransformation(glm::mat4(glm::vec4(6.39331, 0, 0, 0),
                                                  glm::vec4(0, 0.13029, 0, 0),
                                                  glm::vec4(0, 0, 7.45686, 0),
                                                  glm::vec4(0, 0, 0, 1) ));
    m_tischplatte->getAppearance().setObjectColor(Functions::getWhite());
    m_tischplatte->setParent(m_world);

    m_tischbein_ul = new CgSceneGraphEntity(obj_cube);
    m_tischbein_ul->setAppearance(new CgAppearance());
    m_tischbein_ul->setObjectTransformation(glm::mat4(glm::vec4(0.66342, 0, 0, 0),
                                                  glm::vec4(0, 4.97186, 0, 0),
                                                  glm::vec4(0, 0, 0.66342, 0),
                                                  glm::vec4(-2.85, -2.55, -3.4, 1)));
    m_tischbein_ul->getAppearance().setObjectColor(Functions::getWhite());
    m_tischplatte->pushChildren(m_tischbein_ul);

    m_tischbein_ur = new CgSceneGraphEntity(obj_cube);
    m_tischbein_ur->setAppearance(new CgAppearance());
    m_tischbein_ur->setObjectTransformation(glm::mat4(glm::vec4(0.66342, 0, 0, 0),
                                                  glm::vec4(0, 4.97186, 0, 0),
                                                  glm::vec4(0, 0, 0.66342, 0),
                                                  glm::vec4(-2.85, -2.55, 3.4, 1)));
    m_tischbein_ur->getAppearance().setObjectColor(Functions::getWhite());
    m_tischplatte->pushChildren(m_tischbein_ur);

    m_tischbein_or = new CgSceneGraphEntity(obj_cube);
    m_tischbein_or->setAppearance(new CgAppearance());
    m_tischbein_or->setObjectTransformation(glm::mat4(glm::vec4(0.66342, 0, 0, 0),
                                                  glm::vec4(0, 4.97186, 0, 0),
                                                  glm::vec4(0, 0, 0.66342, 0),
                                                  glm::vec4(2.85, -2.55, 3.4, 1)));
    m_tischbein_or->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_tischplatte->pushChildren(m_tischbein_or);

    m_tischbein_ol = new CgSceneGraphEntity(obj_cube);
    m_tischbein_ol->setAppearance(new CgAppearance());
    m_tischbein_ol->setObjectTransformation(glm::mat4(glm::vec4(0.66342, 0, 0, 0),
                                                  glm::vec4(0, 4.97186, 0, 0),
                                                  glm::vec4(0, 0, 0.66342, 0),
                                                  glm::vec4(2.85, -2.55, -3.4, 1)));
    m_tischbein_ol->getAppearance().setObjectColor(Functions::getWhite());
    m_tischplatte->pushChildren(m_tischbein_ol);


    //Checkboard
    m_checkerboard = new CgSceneGraphEntity(obj_cube);
    m_checkerboard->setAppearance(new CgAppearance());
    m_checkerboard->setObjectTransformation(glm::mat4(glm::vec4(3.50266, 0, 0, 0),
                                                  glm::vec4(0, 0.243235, 0, 0),
                                                  glm::vec4(0, 0, 3.50266, 0),
                                                  glm::vec4(0, 0.2, 0, 1) ));
    m_checkerboard->getAppearance().setObjectColor(Functions::getWhite());
    m_tischplatte->pushChildren(m_checkerboard);


    m_box_plate = new CgSceneGraphEntity(obj_cube);
    m_box_plate->setAppearance(new CgAppearance());
    m_box_plate->setObjectTransformation(glm::mat4(glm::vec4(2.78241, 0, 0, 0),
                                                  glm::vec4(0, 0.242627, 0, 0),
                                                  glm::vec4(0, 0, 1.24004, 0),
                                                  glm::vec4(-7.45058e-09, 0.2, -2.8, 1) ));
    m_box_plate->getAppearance().setObjectColor(Functions::getWhite());
    m_tischplatte->pushChildren(m_box_plate);


    m_box_wand1 = new CgSceneGraphEntity(obj_cube); //aussen seite  - menschensicht link
    m_box_wand1->setAppearance(new CgAppearance());
    m_box_wand1->setObjectTransformation(glm::mat4(glm::vec4(2.78241, 0, 0, 0),
                                                  glm::vec4(0, 0.799306, 0, 0),
                                                  glm::vec4(0, 0, 0.15936, 0),
                                                  glm::vec4(-7.45058e-09, 0.65, -3.35, 1) ));
    m_box_wand1->getAppearance().setObjectColor(Functions::getWhite());
    m_box_plate->pushChildren(m_box_wand1);

    m_box_wand2 = new CgSceneGraphEntity(obj_cube); //innenseite - menschensicht rechts
    m_box_wand2->setAppearance(new CgAppearance());
    m_box_wand2->setObjectTransformation(glm::mat4(glm::vec4(2.78241, 0, 0, 0),
                                                  glm::vec4(0, 0.799306, 0, 0),
                                                  glm::vec4(0, 0, 0.15936, 0),
                                                  glm::vec4(-7.45058e-09, 0.65, -2.25, 1) ));
    m_box_wand2->getAppearance().setObjectColor(Functions::getWhite());
    m_box_plate->pushChildren(m_box_wand2);

    m_box_wand3 = new CgSceneGraphEntity(obj_cube); //innenseite - menschensicht vorne
    m_box_wand3->setAppearance(new CgAppearance());
    m_box_wand3->setObjectTransformation(glm::mat4(glm::vec4(0.22536, 0, 0, 0),
                                                  glm::vec4(0, 0.799306, 0, 0),
                                                  glm::vec4(0, 0, 1.00745, 0),
                                                  glm::vec4(-1.3, 0.65, -2.8, 1) ));
    m_box_wand3->getAppearance().setObjectColor(Functions::getWhite());
    m_box_plate->pushChildren(m_box_wand3);

    m_box_wand4 = new CgSceneGraphEntity(obj_cube); //innenseite - menschensicht hinten
    m_box_wand4->setAppearance(new CgAppearance());
    m_box_wand4->setObjectTransformation(glm::mat4(glm::vec4(0.22536, 0, 0, 0),
                                                  glm::vec4(0, 0.799306, 0, 0),
                                                  glm::vec4(0, 0, 1.00745, 0),
                                                  glm::vec4(1.3, 0.65, -2.8, 1) ));
    m_box_wand4->getAppearance().setObjectColor(Functions::getWhite());
    m_box_plate->pushChildren(m_box_wand4);

    // team 1
    m_b_rook_1 = new CgSceneGraphEntity(obj_rook); //links
    m_b_rook_1->setAppearance(new CgAppearance());
    m_b_rook_1->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                glm::vec4(0, 0.237827, 0, 0),
                                                glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(-1.6, 0.3, -1.7, 1) ));
    m_b_rook_1->getAppearance().setObjectColor(Functions::getChessPink());
    m_checkerboard->pushChildren(m_b_rook_1);



    m_b_rook_2 = new CgSceneGraphEntity(obj_rook); //rechts
    m_b_rook_2->setAppearance(new CgAppearance());
    m_b_rook_2->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                glm::vec4(0, 0.237827, 0, 0),
                                                glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(-1.6, 0.3, 1.4, 1) ));
    m_b_rook_2->getAppearance().setObjectColor(Functions::getChessPink());
    m_checkerboard->pushChildren(m_b_rook_2);

    m_b_knight_1 = new CgSceneGraphEntity(obj_knight); //links
    m_b_knight_1->setAppearance(new CgAppearance());
    m_b_knight_1->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                    glm::vec4(-1.6, 0.3, -1.2, 1) ));
    m_b_knight_1->getAppearance().setObjectColor(Functions::getChessPink());
    m_checkerboard->pushChildren(m_b_knight_1);



    m_b_knight_2 = new CgSceneGraphEntity(obj_knight); //rechts
    m_b_knight_2->setAppearance(new CgAppearance());
    m_b_knight_2->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(-1.6, 0.3, 1.0, 1) ));
    m_b_knight_2->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_knight_2);


    m_b_bishop_1 = new CgSceneGraphEntity(obj_bishop); //links
    m_b_bishop_1->setAppearance(new CgAppearance());
    m_b_bishop_1->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                    glm::vec4(-1.6, 0.3, 0.55, 1) ));
    m_b_bishop_1->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_bishop_1);



    m_b_bishop_2 = new CgSceneGraphEntity(obj_bishop); //rechts
    m_b_bishop_2->setAppearance(new CgAppearance());
    m_b_bishop_2->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(-1.6, 0.3, -0.8, 1) ));
    m_b_bishop_2->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_bishop_2);


    m_b_queen = new CgSceneGraphEntity(obj_queen); //innenseite - menschensicht hinten
    m_b_queen->setAppearance(new CgAppearance());
    m_b_queen->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                 glm::vec4(0, 0.237827, 0, 0),
                                                 glm::vec4(0, 0, 0.237827, 0),
                                                 glm::vec4(-1.6, 0.3, -0.3, 1) ));
    m_b_queen->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_queen);

    m_b_king = new CgSceneGraphEntity(obj_king); //innenseite - menschensicht hinten
    m_b_king->setAppearance(new CgAppearance());
    m_b_king->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                glm::vec4(0, 0.237827, 0, 0),
                                                glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(-1.6, 0.3, 0.15, 1) ));
    m_b_king->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_king);


    m_b_pawn_1 = new CgSceneGraphEntity(obj_pawn); //links
    m_b_pawn_1->setAppearance(new CgAppearance());
    m_b_pawn_1->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, -1.55, 1) ));
    m_b_pawn_1->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_1);

    m_b_pawn_2 = new CgSceneGraphEntity(obj_pawn);
    m_b_pawn_2->setAppearance(new CgAppearance());
    m_b_pawn_2->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, -1.1, 1) ));
    m_b_pawn_2->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_2);

    m_b_pawn_3= new CgSceneGraphEntity(obj_pawn);
    m_b_pawn_3->setAppearance(new CgAppearance());
    m_b_pawn_3->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, -0.65, 1) ));
    m_b_pawn_3->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_3);

    m_b_pawn_4= new CgSceneGraphEntity(obj_pawn);
    m_b_pawn_4->setAppearance(new CgAppearance());
    m_b_pawn_4->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, -0.2, 1) ));
    m_b_pawn_4->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_4);


    m_b_pawn_5= new CgSceneGraphEntity(obj_pawn);
    m_b_pawn_5->setAppearance(new CgAppearance());
    m_b_pawn_5->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, 0.25, 1) ));
    m_b_pawn_5->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_5);

    m_b_pawn_6= new CgSceneGraphEntity(obj_pawn);
    m_b_pawn_6->setAppearance(new CgAppearance());
    m_b_pawn_6->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, 0.7, 1) ));
    m_b_pawn_6->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_6);

    m_b_pawn_7= new CgSceneGraphEntity(obj_pawn);
    m_b_pawn_7->setAppearance(new CgAppearance());
    m_b_pawn_7->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, 1.15, 1) ));
    m_b_pawn_7->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_7);

    m_b_pawn_8= new CgSceneGraphEntity(obj_pawn);
    m_b_pawn_8->setAppearance(new CgAppearance());
    m_b_pawn_8->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(-1.15, 0.3, 1.55, 1) ));
    m_b_pawn_8->getAppearance().setObjectColor(Functions::getChessPink() );
    m_checkerboard->pushChildren(m_b_pawn_8);

    //team 2
    m_w_rook_1 = new CgSceneGraphEntity(obj_rook);
    m_w_rook_1->setAppearance(new CgAppearance());
    m_w_rook_1->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                glm::vec4(0, 0.237827, 0, 0),
                                                glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(1.4, 0.3, -1.7, 1) ));
    m_w_rook_1->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_rook_1);



    m_w_rook_2 = new CgSceneGraphEntity(obj_rook); //rechts
    m_w_rook_2->setAppearance(new CgAppearance());
    m_w_rook_2->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                glm::vec4(0, 0.237827, 0, 0),
                                                glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(1.4, 0.3, 1.4, 1) ));
    m_w_rook_2->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_rook_2);

    m_w_knight_1 = new CgSceneGraphEntity(obj_knight); //links
    m_w_knight_1->setAppearance(new CgAppearance());
    m_w_knight_1->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                    glm::vec4(1.4, 0.3, -1.2, 1) ));
    m_w_knight_1->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_knight_1);



    m_w_knight_2 = new CgSceneGraphEntity(obj_knight); //rechts
    m_w_knight_2->setAppearance(new CgAppearance());
    m_w_knight_2->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(1.4, 0.3, 1.0, 1) ));
    m_w_knight_2->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_knight_2);


    m_w_bishop_1 = new CgSceneGraphEntity(obj_bishop); //links
    m_w_bishop_1->setAppearance(new CgAppearance());
    m_w_bishop_1->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                    glm::vec4(1.4, 0.3, 0.55, 1) ));
    m_w_bishop_1->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_bishop_1);



    m_w_bishop_2 = new CgSceneGraphEntity(obj_bishop); //rechts
    m_w_bishop_2->setAppearance(new CgAppearance());
    m_w_bishop_2->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                    glm::vec4(0, 0.237827, 0, 0),
                                                    glm::vec4(0, 0, 0.237827, 0),
                                                glm::vec4(1.4, 0.3, -0.8, 1) ));
    m_w_bishop_2->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_bishop_2);

    m_w_king = new CgSceneGraphEntity(obj_king); //innenseite - menschensicht hinten
    m_w_king->setAppearance(new CgAppearance());
    m_w_king->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                glm::vec4(0, -0.0310426, 0.235792, 0),
                                                glm::vec4(0, -0.235792, -0.0310426, 0),
                                                glm::vec4(0.65, 0.6, 0.15, 1) ));
    m_w_king->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_king);


    m_w_pawn_1 = new CgSceneGraphEntity(obj_pawn); //links
    m_w_pawn_1->setAppearance(new CgAppearance());
    m_w_pawn_1->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, -1.55, 1) ));
    m_w_pawn_1->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_1);

    m_w_pawn_2 = new CgSceneGraphEntity(obj_pawn);
    m_w_pawn_2->setAppearance(new CgAppearance());
    m_w_pawn_2->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, -1.1, 1) ));
    m_w_pawn_2->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_2);

    m_w_pawn_3= new CgSceneGraphEntity(obj_pawn);
    m_w_pawn_3->setAppearance(new CgAppearance());
    m_w_pawn_3->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, -0.65, 1) ));
    m_w_pawn_3->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_3);

    m_w_pawn_4= new CgSceneGraphEntity(obj_pawn);
    m_w_pawn_4->setAppearance(new CgAppearance());
    m_w_pawn_4->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, -0.2, 1) ));
    m_w_pawn_4->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_4);


    m_w_pawn_5= new CgSceneGraphEntity(obj_pawn);
    m_w_pawn_5->setAppearance(new CgAppearance());
    m_w_pawn_5->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, 0.25, 1) ));
    m_w_pawn_5->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_5);

    m_w_pawn_6= new CgSceneGraphEntity(obj_pawn);
    m_w_pawn_6->setAppearance(new CgAppearance());
    m_w_pawn_6->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, 0.7, 1) ));
    m_w_pawn_6->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_6);

    m_w_pawn_7= new CgSceneGraphEntity(obj_pawn);
    m_w_pawn_7->setAppearance(new CgAppearance());
    m_w_pawn_7->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, 1.15, 1) ));
    m_w_pawn_7->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_7);

    m_w_pawn_8= new CgSceneGraphEntity(obj_pawn);
    m_w_pawn_8->setAppearance(new CgAppearance());
    m_w_pawn_8->setObjectTransformation(glm::mat4(glm::vec4(0.0236495, 0, 0, 0),
                                     glm::vec4(0, 0.0236495, 0, 0),
                                     glm::vec4(0, 0, 0.0236495, 0),
                                     glm::vec4(1.15, 0.3, 1.55, 1) ));
    m_w_pawn_8->getAppearance().setObjectColor(Functions::getChessBlue());
    m_checkerboard->pushChildren(m_w_pawn_8);

    m_w_queen = new CgSceneGraphEntity(obj_queen); //innenseite - menschensicht hinten
    m_w_queen->setAppearance(new CgAppearance());
    m_w_queen->setObjectTransformation(glm::mat4(glm::vec4(0.237827, 0, 0, 0),
                                                 glm::vec4(0, 0.237827, 0, 0),
                                                 glm::vec4(0, 0, 0.237827, 0),
                                                 glm::vec4(0, 0.3, -2.95, 1) ));
    m_w_queen->getAppearance().setObjectColor(Functions::getChessBlue());
    m_box_plate->pushChildren(m_w_queen);


    // Children of world
    m_world->pushChildren(m_stuhlbein_ul);
    m_world->pushChildren(m_tischplatte);


   this->setRootNode(m_world);

   initializeInorderList(m_world);

   // coordination system
   std::vector<CgPolyline*> polylines;
   std::vector<glm::vec3> vertices;
   vertices.push_back(glm::vec3(0.0, 0.0, 0.0));
   vertices.push_back(glm::vec3(1.0, 0.0, 0.0));
   polylines.push_back(new CgPolyline(Functions::getId(), vertices));

   vertices.pop_back();
   vertices.push_back(glm::vec3(0.0, 1.0, 0.0));
   polylines.push_back(new CgPolyline(Functions::getId(), vertices));

   vertices.pop_back();
   vertices.push_back(glm::vec3(0.0, 0.0, 1.0));
   polylines.push_back(new CgPolyline(Functions::getId(), vertices));
   coord_system = new CgCoordSystem(polylines);

   // Polyline Ray
   vertices.clear();
   vertices.push_back(glm::vec3(0.0, 0.0, 0.0));
   vertices.push_back(glm::vec3(0.0, 0.0, 0.0));
   m_ray = new CgRay(Functions::getId(), vertices);
}

CgSceneGraph::~CgSceneGraph() {
    if (m_world!=NULL) {
            delete m_world->getObject();
        for (unsigned int i = 0; i < m_world->getChildren().size(); ++i) {
            delete m_world->getChildren()[i]->getObject();
        }
    }

    if (m_ray != NULL) {
        delete m_ray;
    }

    delete m_root_node;

    for (unsigned int i = 0; i < m_inorder_scene_entities.size(); ++i)
        delete m_inorder_scene_entities[i];

    delete coord_system;

    for (unsigned int i = 0; i < o_all_objects.size(); ++i)
        delete o_all_objects[i];

    delete m_ray;

    // all entities
    delete m_world;
    delete m_stuhlbein_ul;
        delete m_stuhlbein_ur;
        delete m_stuhlbein_ol;
        delete m_stuhlbein_or;
        delete m_stuhlplate;
        delete m_lehne;
        delete m_man;
    delete m_tischbein_ul;
        delete m_tischbein_ur;
        delete m_tischbein_ol;
        delete m_tischbein_or;
        delete m_tischplatte;
        delete m_checkerboard;
            delete m_b_king;
            delete m_b_queen;
            delete m_b_bishop_1;
            delete m_b_bishop_2;
            delete m_b_knight_1;
            delete m_b_knight_2;
            delete m_b_rook_1;
            delete m_b_rook_2;
            delete m_b_pawn_1;
            delete m_b_pawn_2;
            delete m_b_pawn_3;
            delete m_b_pawn_4;
            delete m_b_pawn_5;
            delete m_b_pawn_6;
            delete m_b_pawn_7;
            delete m_b_pawn_8;

            delete m_w_king;
            delete m_w_queen;
            delete m_w_bishop_1;
            delete m_w_bishop_2;
            delete m_w_knight_1;
            delete m_w_knight_2;
            delete m_w_rook_1;
            delete m_w_rook_2;
            delete m_w_pawn_1;
            delete m_w_pawn_2;
            delete m_w_pawn_3;
            delete m_w_pawn_4;
            delete m_w_pawn_5;
            delete m_w_pawn_6;
            delete m_w_pawn_7;
            delete m_w_pawn_8;
        delete m_box_plate;
            delete m_box_wand1;
            delete m_box_wand2;
            delete m_box_wand3;
            delete m_box_wand4;


    delete  obj_man;
    delete  obj_king;
    delete  obj_queen;
    delete  obj_bishop;
    delete  obj_knight;
    delete  obj_rook;
    delete    obj_cube;
    delete     obj_pawn;
}

CgSceneGraphEntity* CgSceneGraph::getCurrentEntity() {
    if (m_index_of_selected_gui_elem != -1) {
        return m_inorder_scene_entities[m_index_of_selected_gui_elem];
    }
    return NULL;
}
glm::vec4 CgSceneGraph::getCurrentEntityOldColor() {
    return m_current_entity_old_color;
}

CgSceneGraphEntity* CgSceneGraph::getNextEntity() {
    // if iterated trough all gui elem then reset index
    if ((int)m_index_of_selected_gui_elem == (int)(m_inorder_scene_entities.size()-1)) {
        m_index_of_selected_gui_elem = -1;
    }
    m_index_of_selected_gui_elem++;
    m_current_entity_old_color = m_inorder_scene_entities[m_index_of_selected_gui_elem]->
            getAppearance().getObjectColor();
    return m_inorder_scene_entities[m_index_of_selected_gui_elem];
}

CgSceneGraphEntity* CgSceneGraph::getRootNode() {
    return m_root_node;
}

CgRay* CgSceneGraph::getRay() { return m_ray; }

void CgSceneGraph::setRenderer(CgBaseRenderer* renderer) {
    for (unsigned int i=0; i < o_all_objects.size() ; ++i) {
        renderer->init(o_all_objects[i]);
    }
    for (unsigned int i=0; i<coord_system->getCoordSystem().size(); ++i) {
        renderer->init(coord_system->getCoordSystem()[i]);
    }
    setAABBForAllChildren(renderer, m_root_node);
    renderer->init(m_ray);
}

void CgSceneGraph::setAABBForAllChildren(CgBaseRenderer* renderer, CgSceneGraphEntity* entity) {
    calculateAABB(entity);
    renderer->init(entity->getAABB());
    for (unsigned int i = 0; i < entity->getChildren().size(); ++i) {
        setAABBForAllChildren(renderer, entity->getChildren()[i]);
    }
}

void CgSceneGraph::setRootNode(CgSceneGraphEntity* root) {
    m_root_node = root;
}

void CgSceneGraph::pushMatrix() {
    m_modelview_matrix_stack.push(m_modelview_matrix_stack.top());
}

void CgSceneGraph::popMatrix() {
    m_modelview_matrix_stack.pop();
}

void CgSceneGraph::applyTransform(glm::mat4 arg) {
    m_modelview_matrix_stack.top()*=arg;
}

void CgSceneGraph::initializeInorderList(CgSceneGraphEntity* entity) {
    m_inorder_scene_entities.push_back(entity);
    for (unsigned int i=0; i<entity->getChildren().size(); ++i) {
        initializeInorderList(entity->getChildren()[i]);
    }
}

void CgSceneGraph::render(CgSceneControl* scene_control, CgSceneGraphEntity* entity) {
    scene_control->setCurrentTransformation(m_modelview_matrix_stack.top()*entity->getObjectTransformation());
    scene_control->getRenderer()->setUniformValue("mycolor", entity->getAppearance().getObjectColor());

    // render objects of the group
    scene_control->getRenderer()->render(entity->getObject());
    if (scene_control->getSelectedEntity() == entity && scene_control->getShowAABB() == true) {
        scene_control->getRenderer()->setUniformValue("mycolor", Functions::getYellow());
        scene_control->getRenderer()->render(entity->getAABB());
    }

    // iterate through children recursive
    for (unsigned int i=0; i < entity->getChildren().size(); ++i) {
        pushMatrix();
        // adjust aabb if transformation of entity has changedq
        if (m_modelview_matrix_stack.top() != entity->getChildren()[i]->getCurrentTransformation()
                * entity->getChildren()[i]->getCurrentTransformation()) {
            calculateAABB(entity);
        }
        applyTransform(entity->getChildren()[i]->getCurrentTransformation());
        render(scene_control, entity->getChildren()[i]);
        m_modelview_matrix_stack.pop();
    }
}

void CgSceneGraph::startIntersection(CgSceneControl* scene_control, CgSceneGraphEntity* entity) {
    m_intersections.clear();
    checkIntersection(scene_control, entity);
    std::cout << "Anzahl Schnittpunkte: " << m_intersections.size() << "\n";
}

void CgSceneGraph::checkIntersection(CgSceneControl* scene_control, CgSceneGraphEntity* entity) {
    glm::mat4 currentTransformation = entity->getCurrentTransformation() * entity->getObjectTransformation();
    glm::mat4 currentTransformation_inverse = glm::inverse(currentTransformation);

    CgRay* local_ray = new CgRay(Functions::getId());

    local_ray->setA(currentTransformation_inverse * m_ray->getA());
    local_ray->setB(currentTransformation_inverse * m_ray->getB());
    local_ray->setDirection(currentTransformation_inverse * m_ray->getDirection());

//    entity->local_ray->setA(currentTransformation_inverse * m_ray->getA());
//    entity->local_ray->setB(currentTransformation_inverse * m_ray->getB());
//    entity->local_ray->setDirection(currentTransformation_inverse * m_ray->getDirection());

    pickingIntersection(entity, local_ray);
    delete local_ray;

    // iterate through children recursive
    for (unsigned int i=0; i < entity->getChildren().size(); ++i) {
        checkIntersection(scene_control, entity->getChildren()[i]);
    }
}

void CgSceneGraph::pickingIntersection(CgSceneGraphEntity* entity, CgRay* local_ray) {
    bool aabb_intersection = checkAABBIntersection(entity, local_ray);

    if (aabb_intersection) {
        for (unsigned int i = 0; i < entity->getObject()->getTriangleIndices().size(); i+=3) {
            glm::vec3 a = entity->getObject()->getVertices()[entity->getObject()->getTriangleIndices()[i]];
            glm::vec3 b = entity->getObject()->getVertices()[entity->getObject()->getTriangleIndices()[i+1]];
            glm::vec3 c = entity->getObject()->getVertices()[entity->getObject()->getTriangleIndices()[i]+2];
            CgPlane p {CgPlane(a, b, c)};
            float t;
            glm::vec3 q;
            if (IntersectRayPlane(local_ray, p, t, q))
            {
                float u, v, w;
                Barycentric(a, b, c, q, u, v, w);
                if(u >= 0 && u <= 1 && v >= 0 && v <= 1 && w >= 0 && w <= 1) {
                    glm::vec4 intersection_point = glm::vec4(q[0], q[1], q[2], 1.0);
                    intersection_point = entity->getObjectTransformation() * entity->getCurrentTransformation() * intersection_point;
                    std::cout << "Schnittpunkt: " << glm::to_string(intersection_point) << "\n";
                    m_intersections.push_back(glm::vec3(intersection_point[0], intersection_point[1], intersection_point[2]));
                }
            }
        }
    }
}

bool CgSceneGraph::checkAABBIntersection(CgSceneGraphEntity* entity, CgRay* local_ray) {
    for (unsigned int i = 0; i < entity->getAABB()->getTriangleIndices().size(); i+=3) {
        glm::vec3 a = entity->getAABB()->getVertices()[entity->getAABB()->getTriangleIndices()[i]];
        glm::vec3 b = entity->getAABB()->getVertices()[entity->getAABB()->getTriangleIndices()[i+1]];
        glm::vec3 c = entity->getAABB()->getVertices()[entity->getAABB()->getTriangleIndices()[i]+2];
        CgPlane p {CgPlane(a, b, c)};
        float t;
        glm::vec3 q;
        if (IntersectRayPlane(local_ray, p, t, q))
        {
            float u, v, w;
            Barycentric(a, b, c, q, u, v, w);
            bool next = u >= 0 && u <= 1 && v >= 0 && v <= 1 && w >= 0 && w <= 1;
            if (next)
                std::cout << "hit\n";
            return next;
        }
    }
    return false;
}

bool CgSceneGraph::IntersectRayPlane(CgRay* local_ray, CgPlane& p, float& t, glm::vec3& q) {
    glm::vec3 a = glm::vec3(local_ray->getA()[0], local_ray->getA()[1], local_ray->getA()[2]);
    glm::vec3 ab = glm::vec3(local_ray->getDirection()[0], local_ray->getDirection()[1], local_ray->getDirection()[2]);

    t = (p.d - glm::dot(p.n, a)) / glm::dot(p.n, ab);

    if (std::isfinite(t) && t >= 0.0f ) {
        q = a + t * ab;
        return 1;
    }
    return 0;
}

void CgSceneGraph::Barycentric(glm::vec3& a, glm::vec3& b, glm::vec3& c, glm::vec3& q,
                               float& u, float& v, float& w) {
    glm::vec3 v0 = b - a;
    glm::vec3 v1 = c - a;
    glm::vec3 v2 = q - a;
    float d00 = glm::dot(v0, v0);
    float d01 = glm::dot(v0, v1);
    float d11 = glm::dot(v1, v1);
    float d20 = glm::dot(v2, v0);
    float d21 = glm::dot(v2, v1);
    float denom = d00 * d11 - d01 * d01;
    v = (d11 * d20 - d01 * d21) / denom;
    w = (d00 * d21 - d01 * d20) / denom;
    u = 1.0f - v - w;
}

CgCoordSystem* CgSceneGraph::getCoordSystem() {
    return coord_system;
}

std::vector<glm::vec3> CgSceneGraph::getIntersections() { return m_intersections; }


void CgSceneGraph::pushMatrix(glm::mat4 arg) {
    m_modelview_matrix_stack.push(arg);
}

void CgSceneGraph::calculateAABB(CgSceneGraphEntity* entity) {
    float x_min = INFINITY, x_max = -INFINITY;
    float y_min = INFINITY, y_max = -INFINITY;
    float z_min = INFINITY, z_max = -INFINITY;
    for (unsigned int i = 0; i < entity->getObject()->getVertices().size(); ++i) {
        if (entity->getObject()->getVertices()[i][0] < x_min)
            x_min = entity->getObject()->getVertices()[i][0];
        if (entity->getObject()->getVertices()[i][0] > x_max)
            x_max = entity->getObject()->getVertices()[i][0];
        if (entity->getObject()->getVertices()[i][1] < y_min)
            y_min = entity->getObject()->getVertices()[i][1];
        if (entity->getObject()->getVertices()[i][1] > y_max)
            y_max = entity->getObject()->getVertices()[i][1];
        if (entity->getObject()->getVertices()[i][2] < z_min)
            z_min = entity->getObject()->getVertices()[i][2];
        if (entity->getObject()->getVertices()[i][2] > z_max)
            z_max = entity->getObject()->getVertices()[i][2];
    }
    entity->setAABB(x_min, x_max, y_min, y_max, z_min, z_max);
}
