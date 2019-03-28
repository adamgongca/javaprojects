package net.adamdog.form2njp;

import java.util.ListResourceBundle;

public class TranslaterBundle  extends ListResourceBundle {
    public TranslaterBundle() {
    }

    protected Object[][] getContents() {
        return m_contents;
    }
    
    static final Object m_contents[][] = {
        {
            "Forms2XML", "Oracle Forms 10.1.2 Forms to XML Tool"
        }, {
            "XML2Forms", "Oracle Forms 10.1.2 XML to Forms Tool"
        }, {
            "SchemaGenerator", "Oracle Forms 10.1.2 XML Schema Generator"
        }, {
            "XMLValidator", "Oracle Forms 10.1.2 Forms XML Validator"
        }, {
            "Copyright", "Copyright(c) 2001, 2005, Oracle.  All rights reserved."
        }, {
            "Schema", "Oracle Forms 10.1.2 Forms XML Schema Definition File"
        }, {
            "attach_lib", "Error attaching PLSQL library {0}, check your FORMS_PATH."
        }, {
            "constructor_error", "Error constructing object"
        }, {
            "constructor_find", "Unable to find constructor for {0}"
        }, {
            "db_connect", "Error connecting to database"
        }, {
            "db_continue", "Continuing with no DB connection (Record Group Queries will be lost)"
        }, {
            "file_doesnt_exist", "File {0} does not exist"
        }, {
            "find_class", "Unable to find class {0}"
        }, {
            "general_exception", "ERROR - an exception has been encountered:"
        }, {
            "init_fail", "Error initialising the Forms Jdapi:"
        }, {
            "invalid_option", "Ignoring invalid option: {0}"
        }, {
            "invalid_xml", "File {0} does not contain valid XML "
        }, {
            "invalid_xml_format", "Invalid XML - file {0} does not validate against Forms XML Schema:"
        }, {
            "not_a_module", "File {0} must be a FormModule, ObjectLibrary or MenuModule"
        }, {
            "nothing_to_do", "Nothing to do."
        }, {
            "ogc_error", "ERROR Object group child {0} has no real object."
        }, {
            "overwrite", "File {0} already exists. Use argument OVERWRITE=YES to replace."
        }, {
            "parent_error", "Subclassing error: Check that your FORMS_PATH contains all parent modules."
        }, {
            "prop_read", "Error reading property {0} on {1}"
        }, {
            "rgc_error_find", "Record Group Column {0} not found. Check database query."
        }, {
            "rgc_error_db", "No database connection, Record Group Column {0} not found."
        }, {
            "root_error", "Error the document XML element must be \"Module\""
        }, {
            "sub_obj_find", "Could not find exisiting sub-object {0} on owner {1}"
        }, {
            "prop_value_name", "WARNING: Invalid value ({0}) for property {1} on object {2}."
        }, {
            "list_item_name", "WARNING: Item {0} - all ListItemElements must have an Index, Name and Value."
        }, {
            "missing_image", "ERROR on graphics {0} - cannot find image file {1}"
        }, {
            "schema_fail", "Failed to generate schema"
        }, {
            "db_subclassing", "WARNING: Forms Object {0} in module is subclassed from parent module {1} in database. Please ensure that this can resolved in FORMS_PATH"
        }, {
            "xml_to_forms_stop", "XML file {0} was generated using the option DUMP=ALL and cannot be converted back to original module."
        }, {
            "cache_obj", "Caching {0} for later, parent is {1}"
        }, {
            "module_saved", "Module saved as {0}"
        }, {
            "move_obj_to_end", "Moving {0} to the end"
        }, {
            "move_obj", "Moving {0} to after {1}"
        }, {
            "process_module", "Processing module {0}"
        }, {
            "process_xml", "Processing XML module {0}"
        }, {
            "xml_module_saved", "XML Module saved as {0}"
        }, {
            "schema_saved", "Forms XML Schema saved as {0}"
        }, {
            "validate_success", "{0} validated against the Forms XML Schema."
        }, {
            "image_saved", "Graphics {0} image saved as {1}."
        }, {
            "xml_dump_warn", "XML file {0} generated using the option DUMP=ALL cannot be converted back to a Form Module."
        }, {
            "Forms2XML_usage", "Correct usage: \n   frmf2xml [options] file1 [file2...] \nThe tool will accept .fmb, .olb and .mmb files. \nOptions: (default value in brackets)\nDUMP=ALL/OVERRIDDEN dumps ALL properties or just those OVERRIDDEN (OVERRIDDEN)\nOVERWRITE=YES/NO overwrite files that already exist (NO)\nUSE_PROPERTY_IDS=YES/NO writes out the numeric ID of the property value rather than the property value name (NO)\n\nNOTE : After using the option DUMP=ALL you will NOT be able to reconvert the resulting XML files back to their original format.\n"
        }, {
            "XML2Forms_usage", "Correct usage: \n  frmxml2f [options] file.xml [file2...] \nOptions: (default value in brackets)\nOVERWRITE=YES/NO overwrite files that already exist (NO)\nPRINTTREE=YES/NO prints a forms object tree as the xml is parsed (NO)\nUSERID=database connection string - for record group queries (none)\n"
        }, {
            "Validator_usage", "Correct usage: \n  frmxmlv file.xml [file2...]\n"
        }, {
           "translate_finish", "translate finish: \n "
        }
    };
    
    
}
