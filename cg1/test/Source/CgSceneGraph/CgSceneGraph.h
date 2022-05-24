#ifndef SCENEGRAPH_H
#define SCENEGRAPH_H

#include <vector>
#include <glm/glm.hpp>
#include <stack>
#include <iostream>
#include <string>
#include "CgBase/CgBaseRenderer.h"
#include "CgSceneGraphEntity.h"
#include "CgSceneGraph.h"
#include "CgSceneControl.h"

#include "CgExampleTriangle.h"
#include "CgUnityCube.h"
#include "CgRotation.h"
#include "CgLoadObjFile.h"
#include "CgPolyline.h"
#include "CgCoordSystem.h"

#include"../CgUtils/Functions.h"

class CgSceneGraphEntity;
class CgSceneControl;
class CgBaseRenderer;

class CgSceneGraph {
public:
    CgSceneGraph();
    ~CgSceneGraph();

    void setRenderer(CgBaseRenderer* renderer);
    void setRootNode(CgSceneGraphEntity* root);

    CgSceneGraphEntity* getRootNode();
    glm::vec4 getCurrentEntityOldColor();
    CgSceneGraphEntity* getCurrentEntity();
    CgSceneGraphEntity* getNextEntity();
    CgCoordSystem* getCoordSystem();

    void initializeInorderList(CgSceneGraphEntity* entity);

    void render(CgSceneControl* scene_control, CgSceneGraphEntity* entity);
private:
    void pushMatrix();
    void popMatrix();
    void applyTransform(glm::mat4 arg);

    CgSceneGraphEntity* m_root_node;
    std::stack<glm::mat4> m_modelview_matrix_stack;

    int m_index_of_selected_gui_elem;
    glm::vec4 m_current_entity_old_color;
    std::vector<CgSceneGraphEntity*> m_inorder_scene_entities;

    CgCoordSystem* coord_system;

    std::vector<CgBaseRenderableObject*> o_all_objects;

    // all entities
    CgSceneGraphEntity* m_world;
    CgSceneGraphEntity* m_stuhlbein_ul;
    CgSceneGraphEntity* m_stuhlbein_ur;
    CgSceneGraphEntity* m_stuhlbein_ol;
    CgSceneGraphEntity* m_stuhlbein_or;
    CgSceneGraphEntity* m_stuhlplate;
    CgSceneGraphEntity* m_man;
    CgSceneGraphEntity* m_lehne;
    CgSceneGraphEntity* m_king;
    CgSceneGraphEntity* m_checkerboard;

    //all objs
    CgLoadObjFile*  obj_man;
    CgLoadObjFile*  obj_king;
    CgLoadObjFile*  obj_queen;
    CgLoadObjFile*  obj_bishop;
    CgLoadObjFile*  obj_knight;
    CgLoadObjFile*  obj_rook;
    CgUnityCube*    obj_cube;
    CgRotation*     obj_pawn;
};
#endif // SCENEGRAPH_H
