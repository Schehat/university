<<<<<<< HEAD
#include "CgSceneGraph.h"

CgSceneGraph::CgSceneGraph()
{
    // create all objs
    obj_man     = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Man_sitting.obj"));
    obj_king    = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("King.obj"));
    obj_queen   = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Queen.obj"));
    obj_bishop  = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Bishop.obj"));
    obj_bishop  = new CgLoadObjFile(Functions::getId(), Functions::getPathtoObj("Knight.obj"));
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
    o_all_objects.push_back(obj_man);
//    o_all_objects.push_back(obj_king);
//    o_all_objects.push_back(obj_queen);
//    o_all_objects.push_back(obj_bishop);
//    o_all_objects.push_back(obj_knight);
//    o_all_objects.push_back(obj_rook);

    // Initialize World
    m_world = new CgSceneGraphEntity(obj_cube);
    m_world->setAppearance(new CgAppearance());
    m_world->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_world->setObjectTransformation(glm::scale(m_world->getObjectTransformation(),
                                                glm::vec3(0.01, 0.01, 0.01)));
    m_modelview_matrix_stack.push(m_world->getCurrentTransformation());

    // Initialize Stuhl
    m_stuhlbein_ul = new CgSceneGraphEntity(obj_cube);
    m_stuhlbein_ul->setCurrentTransformation(glm::mat4(glm::vec4(0.66342, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 2.88165, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 0.66342, 0.0),
                                                  glm::vec4(-4.7, -3.7, 0.0, 1.0)));
    m_stuhlbein_ul->setAppearance(new CgAppearance());
    m_stuhlbein_ul->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_stuhlbein_ul->setParent(m_world);

    m_stuhlbein_ur = new CgSceneGraphEntity(obj_cube);
    m_stuhlbein_ur->setAppearance(new CgAppearance());
    m_stuhlbein_ur->setObjectTransformation(glm::mat4(glm::vec4(1.0, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 1.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 1.0, 0.0),
                                                  glm::vec4(2.5, 0.0, 0.0, 1.0)));
    m_stuhlbein_ur->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_stuhlbein_ul->pushChildren(m_stuhlbein_ur);

    m_stuhlbein_ol = new CgSceneGraphEntity(obj_cube);
    m_stuhlbein_ol->setAppearance(new CgAppearance());
    m_stuhlbein_ol->setObjectTransformation(glm::mat4(glm::vec4(1.0, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 1.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 1.0, 0.0),
                                                  glm::vec4(0.0, 0.0, -3.0, 1.0)));
    m_stuhlbein_ol->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
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
    m_stuhlplate->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_stuhlbein_ul->pushChildren(m_stuhlplate);

    m_lehne = new CgSceneGraphEntity(obj_cube);
    m_lehne->setAppearance(new CgAppearance());
    m_lehne->setObjectTransformation(glm::mat4(glm::vec4(0.397214, 0, 0, 0),
                                             glm::vec4(0, 1.52438, 0, 0),
                                             glm::vec4(0, 0, 3.86169, 0),
                                             glm::vec4(-0.25, 1.3, -1.45, 1)));
    m_lehne->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_stuhlbein_ul->pushChildren(m_lehne);

    // initiliaze man
    m_man = new CgSceneGraphEntity(obj_man);
    m_man->setAppearance(new CgAppearance());
    m_man->setObjectTransformation(glm::mat4(glm::vec4(-0.0349137, 0, -0.265196, 0),
                                             glm::vec4(0, 0.0659707, 0, 0),
                                             glm::vec4(0.165278, 0, -0.0217593, 0),
                                             glm::vec4(3.85, -0.6, -1.55, 1)));
    m_man->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_stuhlbein_ul->pushChildren(m_man);

//    m_king = new CgSceneGraphEntity(o_king);
//    m_king->setAppearance(new CgAppearance());
//    m_king->setObjectTransformation(glm::mat4(glm::vec4(0.397214, 0, 0, 0),
//                                             glm::vec4(0, 1.52438, 0, 0),
//                                             glm::vec4(0, 0, 3.86169, 0),
//                                             glm::vec4(-0.25, 1.3, -1.45, 1)));
//    m_king->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
//    m_stuhlbein_ul->pushChildren(m_king);

    // Children of world

    m_world->pushChildren(m_stuhlbein_ul);
    m_world->pushChildren(m_stuhlbein_ul);

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
}

CgSceneGraph::~CgSceneGraph() {
    if (m_world!=NULL) {
            delete m_world->getObject();
        for (unsigned int i = 0; i < m_world->getChildren().size(); ++i) {
            delete m_world->getChildren()[i]->getObject();
        }
    }
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

void CgSceneGraph::setRenderer(CgBaseRenderer* renderer) {
    for (unsigned int i=0; i < o_all_objects.size() ; ++i) {
        renderer->init(o_all_objects[i]);
    }
    for (unsigned int i=0; i<coord_system->getCoordSystem().size(); ++i) {
        renderer->init(coord_system->getCoordSystem()[i]);
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

    // iterate through children recursive
    for (unsigned int i=0; i < entity->getChildren().size(); ++i) {
        pushMatrix();
        applyTransform(entity->getChildren()[i]->getCurrentTransformation());
        render(scene_control, entity->getChildren()[i]);
        m_modelview_matrix_stack.pop();
    }
}

CgCoordSystem* CgSceneGraph::getCoordSystem() {
    return coord_system;
}
=======
#include "CgSceneGraph.h"

CgSceneGraph::CgSceneGraph()
{
    m_triangle   =nullptr;
    m_cube       =nullptr;
    m_rotation   =nullptr;
    m_loadFile   =nullptr;
    m_polyline   =nullptr;

    m_sun       =nullptr;
    m_planet1   =nullptr;
    m_planet2   =nullptr;
    m_moon1     =nullptr;
    m_moon2     =nullptr;
    coord_system=nullptr;

    m_index_of_selected_gui_elem = -1;
    std::vector<CgBaseRenderableObject*> objects;

   m_human = new CgLoadObjFile(Functions::getId(),"/home/schehat/university/cg1/test/Source/CgData/Man_sitting.obj");
   m_cube = new CgUnityCube(Functions::getId());
   objects.push_back(m_human);

    // Initialize sun
    m_sun = new CgSceneGraphEntity(objects);
    m_sun->setAppearance(new CgAppearance());
    m_sun->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_modelview_matrix_stack.push(m_sun->getCurrentTransformation());

    // Initialize planet 1
    m_planet1 = new CgSceneGraphEntity(objects);
    m_planet1->setCurrentTransformation(glm::mat4(glm::vec4(0.5, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.5, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 0.5, 0.0),
                                                  glm::vec4(1.0, 1.0, 0.0, 1.0)));
    m_planet1->setAppearance(new CgAppearance());
    m_planet1->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_planet1->setParent(m_sun);

    // Initialize planet 2
    m_planet2 = new CgSceneGraphEntity(objects);
    m_planet2->setCurrentTransformation(glm::mat4(glm::vec4(0.5, 0.0, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.5, 0.0, 0.0),
                                                  glm::vec4(0.0, 0.0, 0.5, 0.0),
                                                  glm::vec4(0.0, -1.0, -1.0, 1.0)));
    m_planet2->setAppearance(new CgAppearance());
    m_planet2->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_planet2->setParent(m_sun);

    // Initialize moon 1
    m_moon1 = new CgSceneGraphEntity(objects);
    m_moon1->setCurrentTransformation(glm::mat4(glm::vec4(0.3, 0.0, 0.0, 0.0),
                                                glm::vec4(0.0, 0.3, 0.0, 0.0),
                                                glm::vec4(0.0, 0.0, 0.3, 0.0),
                                                glm::vec4(0.0, 1.0, 0.0, 1.0)));
    m_moon1->setAppearance(new CgAppearance());
    m_moon1->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_moon1->setParent(m_planet1);

    // Initialize moon 2
    m_moon2 = new CgSceneGraphEntity(objects);
    m_moon2->setCurrentTransformation(glm::mat4(glm::vec4(0.4, 0.0, 0.0, 0.0),
                                                glm::vec4(0.0, 0.4, 0.0, 0.0),
                                                glm::vec4(0.0, 0.0, 0.4, 0.0),
                                                glm::vec4(0.0, -1.0, 0.0, 1.0)));
    m_moon2->setAppearance(new CgAppearance());
    m_moon2->getAppearance().setObjectColor(glm::vec4(255.0, 255.0, 255.0, 1.0));
    m_moon2->setParent(m_planet2);

    // Children of planet 1 and planet 2
    m_planet1->pushChildren(m_moon1);
    m_planet2->pushChildren(m_moon2);

    // Children of sun
    m_sun->pushChildren(m_planet1);
    m_sun->pushChildren(m_planet2);

    this->setRootNode(m_sun);

    m_sun = new CgSceneGraphEntity(objects);


   initializeInorderList(m_root_node);

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
}

CgSceneGraph::~CgSceneGraph() {
    if (m_sun!=NULL) {
        for (unsigned int i=0; i<m_sun->getListOfObjects().size(); ++i) {
            delete m_sun->getListOfObjects()[i];
        }
    }
    if (m_planet1!=NULL) {
        for ( unsigned int i=0; i<m_planet1->getListOfObjects().size(); ++i) {
            delete m_planet1->getListOfObjects()[i];
        }
    }
    if (m_planet2!=NULL) {
        for (unsigned int i=0; i<m_planet2->getListOfObjects().size(); ++i) {
            delete m_planet2->getListOfObjects()[i];
        }
    }
    if (m_moon1!=NULL) {
        for ( unsigned int i=0; i<m_moon1->getListOfObjects().size(); ++i) {
            delete m_moon1->getListOfObjects()[i];
        }
    }
    if (m_moon2!=NULL) {
        for ( unsigned int i=0; i<m_moon2->getListOfObjects().size(); ++i) {
            delete m_moon2->getListOfObjects()[i];
        }
    }
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

void CgSceneGraph::setRenderer(CgBaseRenderer* renderer) {
    if (m_sun!=NULL) {
        for (unsigned int i=0; i<m_sun->getListOfObjects().size(); ++i)  {
            renderer->init(m_sun->getListOfObjects()[i]);
        }
        for (unsigned int i=0; i<coord_system->getCoordSystem().size(); ++i) {
            renderer->init(coord_system->getCoordSystem()[i]);
        }
    }

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

void CgSceneGraph::setRootNode(CgSceneGraphEntity* root) {
    m_root_node = root;
}

CgSceneGraphEntity* CgSceneGraph::getRootNode() {
    return m_root_node;
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
    for (unsigned int i=0; i < entity->getListOfObjects().size(); ++i) {
        scene_control->getRenderer()->render(entity->getListOfObjects()[i]);
    }

    // iterate through children recursive
    for (unsigned int i=0; i < entity->getChildren().size(); ++i) {
        pushMatrix();
        applyTransform(entity->getChildren()[i]->getCurrentTransformation());
        render(scene_control, entity->getChildren()[i]);
        m_modelview_matrix_stack.pop();
    }

}

CgCoordSystem* CgSceneGraph::getCoordSystem() {
    return coord_system;
}
>>>>>>> 2bba44709ff951a034d04fd1e87594f07d0ef76e
